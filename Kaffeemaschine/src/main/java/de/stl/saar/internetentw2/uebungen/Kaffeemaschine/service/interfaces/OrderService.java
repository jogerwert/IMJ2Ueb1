package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CustomerImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.OrderImpl;


public interface OrderService {

	List<OrderImpl> findAllOrders();

	void saveOrder(OrderImpl orderEntity);

	void deleteOrder(OrderImpl orderEntity);

	OrderImpl findOrderById(long orderId);
	
	List<OrderImpl> findOrdersByCustomerEntity(CustomerImpl customerEntity);


}
