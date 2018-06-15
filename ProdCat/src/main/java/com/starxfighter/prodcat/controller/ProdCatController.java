package com.starxfighter.prodcat.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starxfighter.prodcat.models.Category;
import com.starxfighter.prodcat.models.CategoryProduct;
import com.starxfighter.prodcat.models.Product;
import com.starxfighter.prodcat.service.ProdCatService;

@Controller
public class ProdCatController {
	
	private final ProdCatService prodCatService;
	
	public ProdCatController(ProdCatService prodCatService) {
		this.prodCatService = prodCatService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "/prodcat/Index.jsp";
	}
	
	@RequestMapping("/products/new")
	public String newproduct(@ModelAttribute Product product) {
		return "/prodcat/ProdNew.jsp";
	}
	
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute Product product, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("error" + result);
			return "/prodcat/ProdNew.jsp";
		} else {
			prodCatService.createProduct(product);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/categories/new")
	public String newcategory(@ModelAttribute Category category) {
		return "/prodcat/CatNew.jsp";
	}
	
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/prodcat/CatNew.jsp";
		} else {
			prodCatService.createCategory(category);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/products/{id}")
	public String showprod(@PathVariable("id") Long id, Model model, @ModelAttribute CategoryProduct categoryProduct) {
//		find product
		Product product = prodCatService.findProduct(id);
//		get all categories
		List<Category> categories = prodCatService.findAllCat();
//		find where the product is in the table
		List<CategoryProduct> cp = prodCatService.findProdCat(id);
//		remove used entries
		for(int x = 0; x < categories.size(); x++) {
			for(int z = 0; z < cp.size(); z++) {
				if(categories.get(x).getName() == cp.get(z).getCategory().getName()) {
					categories.remove(x);
				}
			}
		}
		model.addAttribute("cp", cp);
		model.addAttribute("prod", product);
		model.addAttribute("cat", categories);
		return "/prodcat/ShowProd.jsp";
	}
	
	@RequestMapping("/categories/{id}")
	public String showcat(@PathVariable("id") Long id, Model model, @ModelAttribute CategoryProduct categoryProduct) {
//		find category
		Category category = prodCatService.findCategory(id);
//		get all products
		List<Product> products = prodCatService.findAllProd();
//		find where the category is in the table
		List<CategoryProduct> cp = prodCatService.findCatProd(id);
//		remove used entries
		for(int x = 0; x < products.size(); x++) {
			for(int z = 0; z < cp.size(); z++) {
				if(products.get(x).getName() == cp.get(z).getProduct().getName()) {
					products.remove(x);
				}
			}
		}
		model.addAttribute("cp", cp);
		model.addAttribute("prod", products);
		model.addAttribute("cat", category);
		return "/prodcat/ShowCat.jsp";
	}
	
	@RequestMapping(value="/products/{pId}", method=RequestMethod.POST)
	public String addCat(@Valid @ModelAttribute CategoryProduct categoryProduct, BindingResult result, @PathVariable("pId") Long id) {
		if(result.hasErrors()) {
			return "/prodcat/ShowProd.jsp";
		} else {
			Product tempProd = prodCatService.findProduct(id);
			categoryProduct.setProduct(tempProd);
			prodCatService.createCatProd(categoryProduct);
			return "redirect:/";
		}
	}
	
	
	@RequestMapping(value="/categories/{cId}", method=RequestMethod.POST)
	public String addProd(@Valid @ModelAttribute CategoryProduct categoryProduct, BindingResult result, @PathVariable("cId") Long id) {
		if(result.hasErrors()) {
			return "/prodcat/ShowCat.jsp";
		} else {
			Category tempCat = prodCatService.findCategory(id);
			categoryProduct.setCategory(tempCat);
			prodCatService.createCatProd(categoryProduct);
			return "redirect:/";
		}
	}
	
//end
}
