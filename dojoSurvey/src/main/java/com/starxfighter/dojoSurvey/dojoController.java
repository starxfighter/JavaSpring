package com.starxfighter.dojoSurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class dojoController {
	
	@RequestMapping("/")
	public String index() {
		return "Index.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String results(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="favLang") String favLang, @RequestParam(value="comment") String comment, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("favlang", favLang);
		model.addAttribute("comment", comment);
		
		return "Results.jsp";
		
	}

}
