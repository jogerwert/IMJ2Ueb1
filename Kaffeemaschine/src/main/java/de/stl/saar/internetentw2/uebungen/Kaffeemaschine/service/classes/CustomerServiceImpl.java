package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CustomerEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CustomerRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CustomerService;

/**
 * Service-Klasse, welche das Kunden-Repository kapselt.
 * Es werden ausgewaehlte Methoden zum Laden/Speichern/Loeschen/Pruefen
 * von Objekten der Datenbank zur Verfuegung gestellt.
 * 
 * @author Dominik Goedicke, Michelle Blau, Johannes Gerwert
 *
 */

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired 
	private CustomerRepository customerRepository;
	
	public Customer createCustomer(String firstName, String lastName) {
		
		Customer customer = new CustomerEntity(firstName, lastName);
		
		return customer;
	}
	
	
	private List<Customer> createCustomers(List<CustomerEntity> customerEntities){
		List<Customer> customers = new ArrayList<Customer>();
		
		for(CustomerEntity customerEntity: customerEntities) {
			Customer customer = customerEntity;
			customers.add(customer);
		}
		
		return customers;
	}

	@Override
	public List<Customer> findAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		
		for (Customer customer : customerRepository.findAll()) {
			customers.add(customer);
		}
		
		return customers;
	}
	
	
	@Override
	public Customer findCustomerById(long customerId) {
		Customer customer = customerRepository.findByCustomerId(customerId);
		return customer;
	}
	
	@Override
	public Customer findCustomerByFirstNameAndLastName(
			String firstName, String lastName) {
		
		Customer customer = customerRepository.findByFirstNameAndLastName(
				firstName, lastName);
		
		return customer;
	}
	
	@Override
	public List<Customer> findCustomerByLastName(String lastName) {
		List<CustomerEntity> customerEntities = customerRepository.findByLastName(lastName);
		List<Customer> customers = createCustomers(customerEntities);
		return customers;
	}
	
	
	/**
	 * Diese Methode speichert/ueberschreibt Kunden-Objekte in der Datenbank.
	 * Im Falle der Speicherung wird das Kunden-Objekt mit einer Id ausgestattet.
	 * Die Id ist der Primaerschluessel.
	 * @param customer - Kunden-Objekt, dessen customerId veraendert wird, sofern es nicht in der DB existiert.
	 */
	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save((CustomerEntity) customer);
	}
	
	/**
	 * Loescht ein uebergebenes Kunden-Objekt aus der Datenbank.
	 * @param customer - Kunden-Objekt
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete((CustomerEntity) customer);
	}


	@Override
	public boolean doesCustomerExist(String firstName, String lastName) {
		Customer customer = findCustomerByFirstNameAndLastName(firstName, lastName);
		
		if (customer!=null) {
			return true;
		}
		
		return false;
	}
}
