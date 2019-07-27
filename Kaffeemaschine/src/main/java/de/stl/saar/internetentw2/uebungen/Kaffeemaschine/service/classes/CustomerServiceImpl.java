package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CustomerEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CustomerRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CustomerService;

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
	
	private CustomerEntity createCustomerEntity(Customer customer) {
		String firstName = customer.getFirstName();
		String lastName = customer.getLastName();
		
		CustomerEntity customerEntity = null;
		customerEntity = findCustomerEntityByFirstNameAndLastName(firstName, lastName);
		
		if(customerEntity == null) {
			customerEntity = new CustomerEntity(firstName, lastName);
		}
		
		return customerEntity;
	}
	
	private CustomerEntity findCustomerEntityByFirstNameAndLastName(
			String firstName, String lastName) {
		CustomerEntity customerEntity = customerRepository.findByFirstNameAndLastName(
				firstName, lastName);
		
		return customerEntity;
	}

	@Override
	public List<Customer> findAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		
		for (CustomerEntity customerEntity : customerRepository.findAll()) {
			Customer customer = customerEntity;
			customers.add(customer);
		}
		
		return customers;
	}
	
	
	@Override
	public Customer findCustomerById(long customerId) {
		CustomerEntity customerEntity = customerRepository.findByCustomerId(customerId);
		Customer customer = customerEntity;
		return customer;
	}
	
	@Override
	public Customer findCustomerByFirstNameAndLastName(
			String firstName, String lastName) {
		CustomerEntity customerEntity = customerRepository.findByFirstNameAndLastName(
				firstName, lastName);
		
		Customer customer = null;
		if(customerEntity != null) {
			customer = customerEntity;
		}
		
		return customer;
	}
	
	@Override
	public List<Customer> findCustomerByLastName(String lastName) {
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
		Customer customer= findCustomerByFirstNameAndLastName(firstName, lastName);
		
		if (customer!=null) {
			return true;
		}
		
		return false;
	}
}
