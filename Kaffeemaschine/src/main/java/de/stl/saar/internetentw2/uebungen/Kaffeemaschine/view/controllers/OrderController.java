package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.view.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	private int orderNumber;
	
	private boolean coffeeSaved = false;
	private boolean teaSaved = false;
	private boolean cocoaSaved = false;
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String order(Model model) {
		
		
		
		return "order";
	}

	
}
