package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.view.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Order;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.forms.CustomerForm;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CustomerService;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.OrderService;

/**
 * SpringMVC-Controller, der die Login-Seiten verwaltet.
 * 
 * @author Johannes Gerwert
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	@Value("${error.message.login}")
	private String errorMessageLogin;

	/**
	 * Verwaltet GET-Anfragen auf die basis- und die login-Adresse.
	 * Erstellt von der view benoetigte Objekte und schreibt diese in das model.
	 * 
	 * @param model Das von Spring uebergebene Model-Objekt
	 * @return Die html-Seite, die nach Ausfuehrung dieser Methode aufgerufen wird
	 */
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String showLogin(Model model) {
		
		CustomerForm customerForm = new CustomerForm();
		model.addAttribute("customerForm", customerForm);
		
		return "login";
	}
	
	/**
	 * Verwaltet POST-Anfragen auf die login-Adresse.
	 * Empfaengt Nutzereingaben die im Form uebergeben wurden und verarbeitet diese weiter.
	 * Hier werden die Login-Daten ueberprueft und der Login ausgefuehrt.
	 * 
	 * @param model Das von Spring uebergebene Model-Objekt
	 * @param httpSession Die Session zur laengerfristigen Speicherung von Objekten
	 * @param customerForm Nutzereingabe die fuer den Login relevante Daten enthaelt
	 * @return Bei erfolgreichem Login wird man zur Bestellung weitergeleitet, ansonsten bleibt man im login-Bildschirm
	 */
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String executeLogin(Model model, HttpSession httpSession,
			@ModelAttribute("customerForm") CustomerForm customerForm) {
		
		String firstName = customerForm.getFirstName();
		String lastName = customerForm.getLastName();
		
		if(firstName != null && firstName.length() > 0
				&& lastName != null && lastName.length() >0) {
			
			Customer customer = customerService
					.findCustomerByFirstNameAndLastName(firstName, lastName);
			if (customer == null) {
				customer = customerService.createCustomer(firstName, lastName);
				customerService.saveCustomer(customer);
			}
			
			httpSession.setAttribute("currentUser", customer);
			
			Order order = orderService.createEmptyOrder(customer);
			httpSession.setAttribute("currentOrder", order);
			
			
			return "redirect:/order";
		}
		
		model.addAttribute("errorMessageLogin", errorMessageLogin);
		return "login";
	}
}
