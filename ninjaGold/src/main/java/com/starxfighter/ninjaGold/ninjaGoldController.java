package com.starxfighter.ninjaGold;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ninjaGoldController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer money = (Integer) session.getAttribute("money");
		ArrayList<String> messages =  new ArrayList<String>();
		if(money == null) {
			messages.add("Welcome to the Ninja Gold Game");
			session.setAttribute("money", 0);
			session.setAttribute("messages", messages);
			return "Index.jsp";
		} else {
			return "Index.jsp";
		}
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam(value="location") String location, HttpSession session) {
		Integer money = (Integer) session.getAttribute("money");
		int coins;
		String route;
		ArrayList<String> messages =  (ArrayList<String>) session.getAttribute("messages");
		Random r = new Random();
		switch (location) {
		case "farm":
			coins = r.nextInt(11) + 10;
			money += coins;
			route = "You won " + coins + " from the farm";
			messages.add(route);
			session.setAttribute("money", money);
			session.setAttribute("messages", messages);
			break;
		case "cave":
			coins = r.nextInt(6) + 5;
			money += coins;
			route = "You won " + coins + " from the cave";
			messages.add(route);
			session.setAttribute("money", money);
			session.setAttribute("messages", messages);
			break;
		case "house":
			coins = r.nextInt(3) + 2;
			money += coins;
			route = "You won " + coins + " from the house";
			messages.add(route);
			session.setAttribute("money", money);
			session.setAttribute("messages", messages);
			break;
		case "casino":
			coins = r.nextInt(6) + 5;
			int winloss = r.nextInt();
			if(winloss < 1) {
				money -= coins;
				route = "You lost " + coins + " from the casino";
				messages.add(route);
				session.setAttribute("money", money);
				session.setAttribute("messages", messages);
				break;
			} else {
				money += coins;
				route = "You won " + coins + " from the casino";
				messages.add(route);
				session.setAttribute("money", money);
				session.setAttribute("messages", messages);
				break;
			}
		}
		return "redirect:/";
		
	}
	

}
