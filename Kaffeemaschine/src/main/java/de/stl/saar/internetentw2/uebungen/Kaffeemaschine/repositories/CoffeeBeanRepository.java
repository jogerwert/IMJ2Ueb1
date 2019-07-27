package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.CoffeeBean;

public interface CoffeeBeanRepository extends CrudRepository<CoffeeBeanEntity, Long> {

	
	List<CoffeeBean> findByCoffeeBeanName(String coffeeBeanName);
	
    
	CoffeeBean findByCoffeeBeanId(long coffeeBeanId);
}
