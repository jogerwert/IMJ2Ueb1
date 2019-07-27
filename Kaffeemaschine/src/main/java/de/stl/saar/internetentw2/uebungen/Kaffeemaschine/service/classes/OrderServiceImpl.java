package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CustomerEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.OrderEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.OrderRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<OrderEntity> findAllOrders() {
		List<OrderEntity> orderEntitiesEntities = new ArrayList<OrderEntity>();	
		for (OrderEntity orderEntity : orderRepository.findAll()) {
			orderEntitiesEntities.add(orderEntity);
		}
		
		return orderEntitiesEntities;
	}

	@Override
	public void saveOrder(OrderEntity orderEntity) {
		orderRepository.save(orderEntity);
		
	}

	@Override
	public void deleteOrder(OrderEntity orderEntity) {
		orderRepository.delete(orderEntity);
		
	}

	@Override
	public OrderEntity findOrderById(long orderId) {
		return orderRepository.findByOrderId(orderId);
	}

	@Override
	public List<OrderEntity> findOrdersByCustomerEntity(CustomerEntity customerEntity) {
		return orderRepository.findByCustomerEntity(customerEntity);
	}


	
	
	

}
