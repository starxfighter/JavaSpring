package com.starxfighter.helloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class humanController {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required = false) String name, @RequestParam(value="lname", required = false) String lname){
		if(name == null) {
			return "<h1>Hello Human!</h1><h4>Welcome to Springboot!</h4>";
		}else {
			if(lname == null) {
				return "<h1>Hello " + name +  " !</h1><h4>Welcome to Springboot!</h4>";
			}else {
				return "<h1>Hello " + name + " " + lname + " !</h1><h4>Welcome to Springboot!</h4>";
			}
		}
	}

}
