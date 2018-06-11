package com.starxfighter.routingTask;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

	@RequestMapping("/{entity}")
		public String rootCall(@PathVariable("entity") String entity) {
			return "The " + entity + " is awsome!";
		}
	
	@RequestMapping("/{location}-dojo/")
		public String burbank(@PathVariable("location") String location) {
		
			if(location == "san") {
				return "SJ dojo is the headquarters";
			}else {
				return location + " dojo is located in Southern California";
			}
	}
	
	@RequestMapping("/{location}-jose/")
	public String sanJose(@PathVariable("location") String location) {
			System.out.println("In the right mapping");
			System.out.println(location);
			return "SJ dojo is the headquarters";

}

//end	
}

