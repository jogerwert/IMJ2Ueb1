package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CustomerEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.model.classes.CustomerImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.model.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CustomerRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired 
	private CustomerRepository customerRepository;
	
	private Customer createCustomer(CustomerEntity customerEntity) {
		long customerId = customerEntity.getCustomerId();
		String firstName = customerEntity.getFirstName();
		String lastName = customerEntity.getLastName();
		
		Customer customer = new CustomerImpl(customerId, firstName, lastName);
		return customer;
	}
	
	private List<Customer> createCustomers(List<CustomerEntity> customerEntities){
		List<Customer> customers = new ArrayList<Customer>();
		
		for(CustomerEntity customerEntity: customerEntities) {
			Customer customer = createCustomer(customerEntity);
			customers.add(customer);
		}
		
		return customers;
	}
	
	private CustomerEntity createCustomerEntity(Customer customer) {
		String firstName = customer.getFirstName();
		String lastName = customer.getLastName();
		CustomerEntity customerEntity = new CustomerEntity(firstName, lastName);
		return customerEntity;
	}

	@Override
	public List<Customer> findAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		
		for (CustomerEntity customerEntity : customerRepository.findAll()) {
			Customer customer = createCustomer(customerEntity);
			customers.add(customer);
		}
		
		return customers;
	}
	
	
	@Override
	public Customer findCustomerById(long customerId) {
		CustomerEntity customerEntity = customerRepository.findByCustomerId(customerId);
		Customer customer = createCustomer(customerEntity);
		return customer;
	}
	
	@Override
	public Customer findCustomerByFirstNameAndLastName(
			String firstName, String lastName) {
		CustomerEntity customerEntity = customerRepository.findByFirstNameAndLastName(
				firstName, lastName);
		
		Customer customer = null;
		if(customerEntity != null) {
			customer = createCustomer(customerEntity);
		}
		
		return customer;
	}
	
	@Override
	public List<Customer> findCustomerByLastName(
			String lastName) {
		List<CustomerEntity> customerEntities = customerRepository.findByLastName(lastName);
		List<Customer> customers = createCustomers(customerEntities);
		return customers;
	}
	
	@Override
	public void saveCustomer(Customer customer) {
		CustomerEntity customerEntity = createCustomerEntity(customer);
		customerRepository.save(customerEntity);
	}
	
	@Override
	public void deleteCustomer(Customer customer) {
		CustomerEntity customerEntity = createCustomerEntity(customer);
		customerRepository.delete(customerEntity);
	}


	@Override
	public boolean doesCustomerExist(String firstName, String lastName) {
		CustomerEntity customerEntity= findCustomerByFirstNameAndLastName(firstName, lastName);
		
		if (customerEntity!=null) {
			return true;
		}
		
		return false;
	}
	

	

}
