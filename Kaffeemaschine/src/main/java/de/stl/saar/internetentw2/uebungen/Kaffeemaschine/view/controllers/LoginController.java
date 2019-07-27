package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.view.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.forms.CustomerForm;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.model.classes.CustomerImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.model.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CustomerService;

@Controller
public class LoginController {
	
	@Autowired
	private CustomerService customerService;
	
	@Value("${error.message}")
	private String errorMessage;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String showLogin(Model model) {
		
		CustomerForm customerForm = new CustomerForm();
		model.addAttribute("customerForm", customerForm);
		
		return "login";
	}
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String executeLogin(Model model,
			@ModelAttribute("customerForm") CustomerForm customerForm) {
		
		String firstName = customerForm.getFirstName();
		String lastName = customerForm.getLastName();
		
		if(firstName != null && firstName.length() > 0
				&& lastName != null && lastName.length() >0) {
			
			Customer customer = customerService
					.findCustomerByFirstNameAndLastName(firstName, lastName);
			if (customer == null) {
				customer = new CustomerImpl(firstName, lastName);
				customerService.saveCustomer(customer);
			}
			
			model.addAttribute("currentUser", customer);
			
			return "order";
		}
		
		model.addAttribute("errorMessage", errorMessage);
		return "login";
	}
}
