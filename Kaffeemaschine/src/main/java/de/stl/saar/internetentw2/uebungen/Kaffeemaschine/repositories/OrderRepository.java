package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.OrderImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Order;

public interface OrderRepository extends CrudRepository<OrderImpl, Long> {

	
	List<Order> findByCustomer(Customer customer);
	
	List<Order> findByDate(Calendar date);
	
	Order findByOrderId(long orderId);
}
