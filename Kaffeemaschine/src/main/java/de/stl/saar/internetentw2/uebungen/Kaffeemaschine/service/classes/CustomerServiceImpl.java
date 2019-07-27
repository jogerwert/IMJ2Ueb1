package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CustomerImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CustomerRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired 
	private CustomerRepository customerRepository;
	
	public Customer createCustomer(String firstName, String lastName) {
		
		CustomerImpl customerEntity = new CustomerImpl(firstName, lastName);
		saveCustomerEntity(customerEntity);
		
		Customer customer = customerEntity;
		return customer;
	}
	
	private void saveCustomerEntity(CustomerImpl customerEntity) {
		customerRepository.save(customerEntity);
	}
	
	private List<Customer> createCustomers(List<CustomerImpl> customerEntities){
		List<Customer> customers = new ArrayList<Customer>();
		
		for(CustomerImpl customerEntity: customerEntities) {
			Customer customer = customerEntity;
			customers.add(customer);
		}
		
		return customers;
	}
	
	private CustomerImpl createCustomerEntity(Customer customer) {
		String firstName = customer.getFirstName();
		String lastName = customer.getLastName();
		Long customerId = customer.getCustomerId();
		
		CustomerImpl customerEntity = new CustomerImpl(firstName, lastName);
		customerEntity.setCustomerId(customerId);
		
		return customerEntity;
	}

	@Override
	public List<Customer> findAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		
		for (CustomerImpl customerEntity : customerRepository.findAll()) {
			Customer customer = customerEntity;
			customers.add(customer);
		}
		
		return customers;
	}
	
	
	@Override
	public Customer findCustomerById(long customerId) {
		CustomerImpl customerEntity = customerRepository.findByCustomerId(customerId);
		Customer customer = customerEntity;
		return customer;
	}
	
	@Override
	public Customer findCustomerByFirstNameAndLastName(
			String firstName, String lastName) {
		CustomerImpl customerEntity = customerRepository.findByFirstNameAndLastName(
				firstName, lastName);
		
		Customer customer = null;
		if(customerEntity != null) {
			customer = customerEntity;
		}
		
		return customer;
	}
	
	@Override
	public List<Customer> findCustomerByLastName(String lastName) {
		List<CustomerImpl> customerEntities = customerRepository.findByLastName(lastName);
		List<Customer> customers = createCustomers(customerEntities);
		return customers;
	}
	
	@Override
	public void saveCustomer(Customer customer) {
		CustomerImpl customerEntity = createCustomerEntity(customer);
		customerRepository.save(customerEntity);
	}
	
	@Override
	public void deleteCustomer(Customer customer) {
		CustomerImpl customerEntity = createCustomerEntity(customer);
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
