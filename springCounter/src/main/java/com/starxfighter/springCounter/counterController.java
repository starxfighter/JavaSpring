package com.starxfighter.springCounter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class counterController {
	
	@RequestMapping("")
		public String index(HttpSession session) {
			Integer counter = (Integer) session.getAttribute("count");
			if(counter == null) {
				session.setAttribute("count", 0);
			} else {
				counter += 1;
				session.setAttribute("count", counter);
			}
			
			return "Index.jsp";
	}
//end
}
