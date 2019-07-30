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

@Controller
public class LoginController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	@Value("${error.message.login}")
	private String errorMessageLogin;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String showLogin(Model model) {
		
		CustomerForm customerForm = new CustomerForm();
		model.addAttribute("customerForm", customerForm);
		
		return "login";
	}
	
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
			
			
			return "menu";
		}
		
		model.addAttribute("errorMessageLogin", errorMessageLogin);
		return "login";
	}
}
