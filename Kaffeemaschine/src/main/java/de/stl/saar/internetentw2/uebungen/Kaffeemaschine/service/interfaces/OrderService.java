package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CustomerEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.OrderEntity;


public interface OrderService {

	List<OrderEntity> findAllOrders();

	void saveOrder(OrderEntity orderEntity);

	void deleteOrder(OrderEntity orderEntity);

	OrderEntity findOrderById(long orderId);
	
	List<OrderEntity> findOrdersByCustomerEntity(CustomerEntity customerEntity);


}
