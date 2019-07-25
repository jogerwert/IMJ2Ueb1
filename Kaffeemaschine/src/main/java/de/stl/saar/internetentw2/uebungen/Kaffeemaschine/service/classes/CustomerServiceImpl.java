package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CustomerEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CustomerRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired 
	private CustomerRepository customerRepository;

	@Override
	public List<CustomerEntity> findAllCustomers() {
		List<CustomerEntity> customerEntities = new ArrayList<CustomerEntity>();
		
		for (CustomerEntity customerEntity : customerRepository.findAll()) {
			customerEntities.add(customerEntity);
		}
		
		return customerEntities;
	}
	
	
	@Override
	public CustomerEntity findCustomerById(long customerId) {
		CustomerEntity customerEntity = customerRepository.findByCustomerId(customerId);
		return customerEntity;
	}
	
	@Override
	public CustomerEntity findCustomerByFirstNameAndLastName(
			String firstName, String lastName) {
		CustomerEntity customerEntity = customerRepository.findByFirstNameAndLastName(
				firstName, lastName);
		return customerEntity;
	}
	
	@Override
	public List<CustomerEntity> findCustomerByLastName(
			String lastName) {
		List<CustomerEntity> customerEntities = customerRepository.findByLastName(lastName);
		return customerEntities;
	}
	
	@Override
	public void saveCustomer(CustomerEntity customerEntity) {
		customerRepository.save(customerEntity);
	}
	
	@Override
	public void deleteCustomer(CustomerEntity customerEntity) {
		customerRepository.delete(customerEntity);
	}
	

	

}
