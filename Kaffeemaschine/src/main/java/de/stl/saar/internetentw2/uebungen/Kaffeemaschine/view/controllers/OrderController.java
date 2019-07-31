package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.view.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

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

/**
 * SpringMVC-Controller, der die Bestellungs-Seiten verwaltet.
 * 
 * @author Johannes Gerwert
 *
 */
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
	
	@Value("${error.message.negative}")
	private String errorMessageNegative;
	
	/**
	 * Verwaltet GET-Anfragen auf die order-Adresse.
	 * Erstellt von der view benoetigte Objekte und schreibt diese in das model.
	 * 
	 * @param model Das von Spring uebergebene Model-Objekt
	 * @param httpSession Die Session zur laengerfristigen Speicherung von Objekten
	 * @return Die html-Seite, die nach Ausfuehrung dieser Methode aufgerufen wird
	 */
	@RequestMapping(value = { "/order" }, method = RequestMethod.GET)
	public String order(Model model, HttpSession httpSession) {
		
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
	
	/**
	 * Verwaltet POST-Anfragen, wenn ein Kaffee bestellt wurde.
	 * Empfaengt Nutzereingaben, die im Form uebergeben wurden und verarbeitet diese weiter.
	 * Hier werden Kaffees erstellt und gespeichert.
	 * 
	 * @param model Das von Spring uebergebene Model-Objekt
	 * @param httpSession Die Session zur laengerfristigen Speicherung von Objekten
	 * @param coffeeForm Nutzereingabe die fuer die Kaffee-Erstellung relevante Daten enthalt
	 * @return Weiterleitung zur Bestellungs-Ansicht
	 */
	@RequestMapping(value = { "/order/coffee" }, method = RequestMethod.POST)
	public String saveCoffee(Model model, HttpSession httpSession,
			RedirectAttributes redirectAttributes,
			@ModelAttribute("coffeeForm") CoffeeForm coffeeForm) {
		
		Order currentOrder = (Order) httpSession.getAttribute("currentOrder");
		
		Integer cookieCount = new Integer(coffeeForm.getCookieCount());
		Integer sugarCount = new Integer(coffeeForm.getSugarCount());
		Boolean withDash = new Boolean(coffeeForm.isWithDash());
		Boolean withChocolate = new Boolean(coffeeForm.isWithChocolate());
		Boolean withMilk = new Boolean(coffeeForm.isWithMilk());
		long coffeeBeanId = coffeeForm.getCoffeeBean();
		
		if(cookieCount < 0 || sugarCount < 0) {
			redirectAttributes.addFlashAttribute("errorMessageCoffeeNegative", errorMessageNegative);
			return "redirect:/order";
		}
		
		CoffeeBean coffeeBean = coffeeBeanService.findByCoffeeBeanId(coffeeBeanId);
		
		Coffee coffee = coffeeService.createCoffee(cookieCount, sugarCount, 
				withDash, withChocolate, withMilk, coffeeBean);
		coffeeService.saveCoffee(coffee);
		
		currentOrder.getCoffeeList().add(coffee);
		orderService.saveOrder(currentOrder);
		Boolean coffeeSaved = true;
		redirectAttributes.addFlashAttribute("coffeeSaved", coffeeSaved);
		
		return "redirect:/order";
	}
	/**
	 * Verwaltet POST-Anfragen, wenn ein Tee bestellt wurde.
	 * Empfaengt Nutzereingaben, die im Form uebergeben wurden und verarbeitet diese weiter.
	 * Hier werden Tees erstellt und gespeichert.
	 * 
	 * @param model Das von Spring uebergebene Model-Objekt
	 * @param httpSession Die Session zur laengerfristigen Speicherung von Objekten
	 * @param coffeeForm Nutzereingabe die fuer die Tee-Erstellung relevante Daten enthalt
	 * @return Weiterleitung zur Bestellungs-Ansicht
	 */
	@RequestMapping(value = { "/order/tea" }, method = RequestMethod.POST)
	public String saveTea(Model model, HttpSession httpSession,
			RedirectAttributes redirectAttributes,
			@ModelAttribute("teaForm") TeaForm teaForm) {
		
		Order currentOrder = (Order) httpSession.getAttribute("currentOrder");
		
		Integer sugarCount = new Integer(teaForm.getSugarCount());
		Boolean withMilk = new Boolean(teaForm.isWithMilk());
		long teaTypeId = teaForm.getTeaType();
		
		if(sugarCount < 0) {
			redirectAttributes.addFlashAttribute("errorMessageTeaNegative", errorMessageNegative);
			return"redirect:/order";
		}
		
		TeaType teaType = teaTypeService.findByTeaTypeId(teaTypeId);
		
		Tea tea = teaService.createTea(sugarCount, withMilk, teaType);
		teaService.saveTea(tea);
		
		currentOrder.getTeaList().add(tea);
		orderService.saveOrder(currentOrder);
		Boolean teaSaved = true;
		redirectAttributes.addFlashAttribute("teaSaved", teaSaved);
		
		
		return "redirect:/order";
	}
	
	/**
	 * Verwaltet POST-Anfragen, wenn ein Kakao bestellt wurde.
	 * Empfaengt Nutzereingaben, die im Form uebergeben wurden und verarbeitet diese weiter.
	 * Hier werden Kakaos erstellt und gespeichert.
	 * 
	 * @param model Das von Spring uebergebene Model-Objekt
	 * @param httpSession Die Session zur laengerfristigen Speicherung von Objekten
	 * @param coffeeForm Nutzereingabe die fuer die Kakao-Erstellung relevante Daten enthalt
	 * @return Weiterleitung zur Bestellungs-Ansicht
	 */
	@RequestMapping(value = { "/order/cocoa" }, method = RequestMethod.POST)
	public String saveCocoa(Model model, HttpSession httpSession,
			RedirectAttributes redirectAttributes,
			@ModelAttribute("cocoaForm") CocoaForm cocoaForm) {
		
		Order currentOrder = (Order) httpSession.getAttribute("currentOrder");
		
		Boolean lowFat = new Boolean(cocoaForm.isLowFat());
		Integer cookieCount = new Integer(cocoaForm.getCookieCount());
		
		if(cookieCount < 0) {
			redirectAttributes.addFlashAttribute("errorMessageCocoaNegative", errorMessageNegative);
			return "redirect:/order";
		}
		
		Cocoa cocoa = cocoaService.createCocoa(lowFat, cookieCount);
		cocoaService.saveCocoa(cocoa);
		
		currentOrder.getCocoaList().add(cocoa);
		orderService.saveOrder(currentOrder);
		Boolean cocoaSaved = true;
		redirectAttributes.addFlashAttribute("cocoaSaved", cocoaSaved);
		
		return "redirect:/order";
	}
	
	/**
	 * Verwaltet GET-Anfragen auf die summary-Adresse.
	 * Erstellt von der view benoetigte Objekte und schreibt diese in das model.
	 * 
	 * @param model Das von Spring uebergebene Model-Objekt
	 * @param httpSession Die Session zur laengerfristigen Speicherung von Objekten
	 * @return Die html-Seite, die nach Ausfuehrung dieser Methode aufgerufen wird
	 */
	@RequestMapping(value = { "/summary" }, method = RequestMethod.GET)
	public String showSummary(Model model, HttpSession httpSession) {
		
		Order currentOrder = (Order) httpSession.getAttribute("currentOrder");
		
		List<List<String>> listList = orderService.summarizeOrder(currentOrder);
		
		List<String> teaSummaryList = listList.get(0);
		List<String> coffeeSummaryList = listList.get(1);
		List<String> cocoaSummaryList = listList.get(2);
		
		model.addAttribute("teaSummaryList", teaSummaryList);
		model.addAttribute("coffeeSummaryList", coffeeSummaryList);
		model.addAttribute("cocoaSummaryList", cocoaSummaryList);
		
		return "summary";
	}
	
}
