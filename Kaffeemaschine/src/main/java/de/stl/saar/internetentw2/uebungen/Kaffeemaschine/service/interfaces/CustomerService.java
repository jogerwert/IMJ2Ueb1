package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;


/**
 * Interface zur Kapselung von Service-Objekten fuer Kunden.
 *  
 * @author Michelle Blau, Dominik Goedicke, Johannes Gerwert
 *
 */
public interface CustomerService {
	
	Customer createCustomer(String firstName, String lastName);

	List<Customer> findAllCustomers();

	void saveCustomer(Customer customer);

	void deleteCustomer(Customer customer);

	Customer findCustomerById(long customerId);

	Customer findCustomerByFirstNameAndLastName(String firstName, 
			String lastName);
	
	boolean doesCustomerExist(String firstName, String lastName);

	List<Customer> findCustomerByLastName(String lastName);


}
