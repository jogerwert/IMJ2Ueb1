package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Order;

/**
 * Interface zur Kapselung von Service-Objekten fuer Bestellungen.
 * 
 * @author Michelle Blau, Dominik Goedicke, Johannes Gerwert
 *
 */

public interface OrderService {

	Order createEmptyOrder(Customer customer);
	
	List<Order> findAllOrders();

	void saveOrder(Order order);

	void deleteOrder(Order order);

	Order findOrderById(long orderId);
	
	List<Order> findOrdersByCustomer(Customer customerEntity);
	
	List<List<String>> summarizeOrder(Order order);


}
