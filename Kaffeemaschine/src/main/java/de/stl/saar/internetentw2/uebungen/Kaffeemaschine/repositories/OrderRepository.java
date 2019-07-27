package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CustomerEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

	
	List<OrderEntity> findByCustomerEntity(CustomerEntity customerEntity);
	
	List<OrderEntity> findByDate(Calendar date);
	
	OrderEntity findByOrderId(long orderId);
}
