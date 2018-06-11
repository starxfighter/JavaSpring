package com.starxfighter.theCode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class codeController {
	
	@RequestMapping("/")
	public String index() {
		System.out.println("in index");
		return "Index.jsp";
	
	
	}
	
	@RequestMapping(value="/try", method=RequestMethod.POST)
	public String guess(@RequestParam(value="guess") String guess) {
		System.out.println("In post section");
		System.out.println("guess" + guess);
		String secret = "bushido";
		if(guess.equals(secret)) {
			System.out.println("in pos");
			return "Code.jsp";
		}else {
			System.out.println("in neg");
			return "redirect:/createError";
		}
	}
	
	@RequestMapping("/createError")
	public String flashMessage(RedirectAttributes  redirectAttributes) {
		System.out.println("in error section");
		redirectAttributes.addFlashAttribute("error", "Wrong! Your no Ninja!!");
		return "redirect:/";
	}

}
