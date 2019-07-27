package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CustomerImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.OrderImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.OrderRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<OrderImpl> findAllOrders() {
		List<OrderImpl> orderEntitiesEntities = new ArrayList<OrderImpl>();	
		for (OrderImpl orderEntity : orderRepository.findAll()) {
			orderEntitiesEntities.add(orderEntity);
		}
		
		return orderEntitiesEntities;
	}

	@Override
	public void saveOrder(OrderImpl orderEntity) {
		orderRepository.save(orderEntity);
		
	}

	@Override
	public void deleteOrder(OrderImpl orderEntity) {
		orderRepository.delete(orderEntity);
		
	}

	@Override
	public OrderImpl findOrderById(long orderId) {
		return orderRepository.findByOrderId(orderId);
	}

	@Override
	public List<OrderImpl> findOrdersByCustomerEntity(CustomerImpl customerEntity) {
		return orderRepository.findByCustomerEntity(customerEntity);
	}


	
	
	

}
