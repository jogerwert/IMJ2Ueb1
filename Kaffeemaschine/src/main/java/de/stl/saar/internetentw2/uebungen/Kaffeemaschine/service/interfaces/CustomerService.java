package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.model.interfaces.Customer;


/**
 * Dieses Interface und seine Implementierung kapseln noch einmal das Repository. Dabei
 * werden nicht die Entity-Klassen zurueckgegeben, sondern die Objekte werden in Objekte 
 * einer anderen Klasse umgewandelt, so dass die Entities ausserhalb der Serviceklasse nicht
 * sichtbar sind.  
 * @author christopher
 *
 */
public interface CustomerService {

	List<Customer> findAllCustomers();

	void saveCustomer(Customer customer);

	void deleteCustomer(Customer customer);

	Customer findCustomerById(long customerId);

	Customer findCustomerByFirstNameAndLastName(String firstName, 
			String lastName);
	
	boolean doesCustomerExist(String firstName, String lastName);

	List<Customer> findCustomerByLastName(String lastName);


}
