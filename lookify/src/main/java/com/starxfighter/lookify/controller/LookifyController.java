package com.starxfighter.lookify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.starxfighter.lookify.model.Music;
import com.starxfighter.lookify.service.LookifyService;

@Controller
public class LookifyController {
	
	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "/lookify/Index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model, @ModelAttribute("music") Music music) {
		List<Music> songs = lookifyService.allMusic();
		model.addAttribute("music", songs);
		return "/lookify/Dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newsong(@ModelAttribute("music") Music music) {
		return "/lookify/New.jsp";
	}
	
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("music") Music music, BindingResult result){
		if(result.hasErrors()) {
			return "/lookify/New.jsp";
		} else {
			lookifyService.createMusic(music);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Music music = lookifyService.findMusic(id);
		model.addAttribute("music", music);
		return "/lookify/Show.jsp";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam(value="search") String search, Model model) {
		List<Music> music = lookifyService.searchArtist(search);
		model.addAttribute("music", music);
		model.addAttribute("search", search);
		return "/lookify/Search.jsp";
	}
	
	@RequestMapping("/search/topten")
	public String topten(Model model) {
		List<Music> music = lookifyService.topTen();
		model.addAttribute("music", music);
		return "/lookify/Top.jsp";
	}
	
	@RequestMapping(value="/song/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		lookifyService.deleteMuisc(id);
		return "redirect:/dashboard";
	}
//end
}
