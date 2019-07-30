package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.view.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Cocoa;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Coffee;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.CoffeeBean;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Order;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Tea;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.forms.CocoaForm;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.forms.CoffeeForm;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.forms.TeaForm;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CocoaService;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CoffeeBeanService;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CoffeeService;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.OrderService;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.TeaService;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.TeaTypeService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CoffeeBeanService coffeeBeanService;
	
	@Autowired
	private CoffeeService coffeeService;
	
	@Autowired
	private TeaTypeService teaTypeService;
	
	@Autowired
	private TeaService teaService;
	
	@Autowired
	private CocoaService cocoaService;
	
	@RequestMapping(value = { "/order" }, method = RequestMethod.GET)
	public String order(Model model) {
		
		CoffeeForm coffeeForm = new CoffeeForm();
		TeaForm teaForm = new TeaForm();
		CocoaForm cocoaForm = new CocoaForm();
		
		model.addAttribute("coffeeForm", coffeeForm);
		model.addAttribute("teaForm", teaForm);
		model.addAttribute("cocoaForm", cocoaForm);
		
		List<CoffeeBean> coffeeBeanList = coffeeBeanService.findAllCoffeeBeans();
		List<TeaType> teaTypeList = teaTypeService.findAllTeaTypes();
		
		model.addAttribute("coffeeBeanList", coffeeBeanList);
		model.addAttribute("teaTypeList", teaTypeList);
		
		return "order";
	}
	
	@RequestMapping(value = { "/order/coffee" }, method = RequestMethod.POST)
	public String saveCoffee(Model model, HttpSession httpSession,
			@ModelAttribute("coffeeForm") CoffeeForm coffeeForm) {
		
		Order currentOrder = (Order) httpSession.getAttribute("currentOrder");
		
		Integer cookieCount = new Integer(coffeeForm.getCookieCount());
		Integer sugarCount = new Integer(coffeeForm.getSugarCount());
		Boolean withDash = new Boolean(coffeeForm.isWithDash());
		Boolean withChocolate = new Boolean(coffeeForm.isWithChocolate());
		Boolean withMilk = new Boolean(coffeeForm.isWithMilk());
		long coffeeBeanId = coffeeForm.getCoffeeBean();
		
		CoffeeBean coffeeBean = coffeeBeanService.findByCoffeeBeanId(coffeeBeanId);
		
		Coffee coffee = coffeeService.createCoffee(cookieCount, sugarCount, 
				withDash, withChocolate, withMilk, coffeeBean);
		coffeeService.saveCoffee(coffee);
		
		currentOrder.getCoffeeList().add(coffee);
		orderService.saveOrder(currentOrder);
		Boolean coffeeSaved = true;
		model.addAttribute("coffeeSaved", coffeeSaved);
		
		return "redirect:/order";
	}
	
	@RequestMapping(value = { "/order/tea" }, method = RequestMethod.POST)
	public String saveTea(Model model, HttpSession httpSession,
			@ModelAttribute("teaForm") TeaForm teaForm) {
		
		Order currentOrder = (Order) httpSession.getAttribute("currentOrder");
		
		Integer sugarCount = new Integer(teaForm.getSugarCount());
		Boolean withMilk = new Boolean(teaForm.isWithMilk());
		long teaTypeId = teaForm.getTeaType();
		
		TeaType teaType = teaTypeService.findByTeaTypeId(teaTypeId);
		
		Tea tea = teaService.createTea(sugarCount, withMilk, teaType);
		teaService.saveTea(tea);
		
		currentOrder.getTeaList().add(tea);
		orderService.saveOrder(currentOrder);
		Boolean teaSaved = true;
		model.addAttribute("teaSaved", teaSaved);
		
		
		return "redirect:/order";
	}
	
	@RequestMapping(value = { "/order/cocoa" }, method = RequestMethod.POST)
	public String saveCocoa(Model model, HttpSession httpSession,
			@ModelAttribute("cocoaForm") CocoaForm cocoaForm) {
		
		Order currentOrder = (Order) httpSession.getAttribute("currentOrder");
		
		Boolean lowFat = new Boolean(cocoaForm.isLowFat());
		Integer cookieCount = new Integer(cocoaForm.getCookieCount());
		
		Cocoa cocoa = cocoaService.createCocoa(lowFat, cookieCount);
		cocoaService.saveCocoa(cocoa);
		
		currentOrder.getCocoaList().add(cocoa);
		orderService.saveOrder(currentOrder);
		Boolean cocoaSaved = true;
		model.addAttribute("cocoaSaved", cocoaSaved);
		
		return "redirect:/order";
	}

	
}
