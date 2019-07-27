package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanImpl;

public interface CoffeeBeanRepository extends CrudRepository<CoffeeBeanImpl, Long> {

	
	List<CoffeeBeanImpl> findByCoffeeBeanName(String coffeeBeanName);
	
    
	CoffeeBeanImpl findByCoffeeBeanId(long coffeeBeanId);
}
