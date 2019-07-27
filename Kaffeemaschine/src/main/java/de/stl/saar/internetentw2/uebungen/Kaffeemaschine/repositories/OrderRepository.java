package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CustomerImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.OrderImpl;

public interface OrderRepository extends CrudRepository<OrderImpl, Long> {

	
	List<OrderImpl> findByCustomerEntity(CustomerImpl customerEntity);
	
	List<OrderImpl> findByDate(Calendar date);
	
	OrderImpl findByOrderId(long orderId);
}
