package com.starxfighter.displayDate;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class displayDateController {
	
	@RequestMapping("")
		public String index() {
		return "Index.jsp";
	}
	
	@RequestMapping("/date")
		public String date(Model model) {
			Date dt = new Date();
			model.addAttribute("date", dt);
			return "Date.jsp";
	}
	
	@RequestMapping("/time")
		public String time(Model model) {
			Date dt = new Date();
			model.addAttribute("date", dt);
			return "Time.jsp";
	}

}
