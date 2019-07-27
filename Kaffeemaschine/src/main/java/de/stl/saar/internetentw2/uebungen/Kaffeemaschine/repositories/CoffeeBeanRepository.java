package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanEntity;

public interface CoffeeBeanRepository extends CrudRepository<CoffeeBeanEntity, Long> {

	
	List<CoffeeBeanEntity> findByCoffeeBeanName(String coffeeBeanName);
	
    
	CoffeeBeanEntity findByCoffeeBeanId(long coffeeBeanId);
}
