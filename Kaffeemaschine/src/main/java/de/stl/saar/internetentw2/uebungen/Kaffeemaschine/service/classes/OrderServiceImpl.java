package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.OrderImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Order;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.OrderRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> findAllOrders() {
		List<Order> orderList = new ArrayList<Order>();	
		for (Order order : orderRepository.findAll()) {
			orderList.add(order);
		}
		
		return orderList;
	}

	@Override
	public void saveOrder(Order order) {
		orderRepository.save((OrderImpl)order);
		
	}

	@Override
	public void deleteOrder(Order order) {
		orderRepository.delete((OrderImpl)order);
		
	}

	@Override
	public Order findOrderById(long orderId) {
		return orderRepository.findByOrderId(orderId);
	}

	@Override
	public List<Order> findOrdersByCustomer(Customer customer) {
		return orderRepository.findByCustomer(customer);
	}


	
	
	

}
