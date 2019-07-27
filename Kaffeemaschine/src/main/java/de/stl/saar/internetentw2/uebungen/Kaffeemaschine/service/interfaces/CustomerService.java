package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CustomerEntity;


/**
 * Dieses Interface und seine Implementierung kapseln noch einmal das Repository. Dabei
 * werden nicht die Entity-Klassen zurueckgegeben, sondern die Objekte werden in Objekte 
 * einer anderen Klasse umgewandelt, so dass die Entities ausserhalb der Serviceklasse nicht
 * sichtbar sind.  
 * @author christopher
 *
 */
public interface CustomerService {

	List<CustomerEntity> findAllCustomers();

	void saveCustomer(CustomerEntity customerEntity);

	void deleteCustomer(CustomerEntity customerEntity);

	CustomerEntity findCustomerById(long customerId);

	CustomerEntity findCustomerByFirstNameAndLastName(String firstName, 
			String lastName);
	
	boolean doesCustomerExist(String firstName, String lastName);

	List<CustomerEntity> findCustomerByLastName(String lastName);


}
