package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Order;


public interface OrderService {

	List<Order> findAllOrders();

	void saveOrder(Order order);

	void deleteOrder(Order order);

	Order findOrderById(long orderId);
	
	List<Order> findOrdersByCustomer(Customer customerEntity);


}
