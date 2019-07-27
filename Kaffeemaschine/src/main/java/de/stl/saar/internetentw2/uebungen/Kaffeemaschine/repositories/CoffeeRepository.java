package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeEntity;

public interface CoffeeRepository extends CrudRepository<CoffeeEntity, Long> {

	
	List<CoffeeEntity> findByCoffeeBeanEntity(CoffeeBeanEntity coffeeBeanEntity);
	
	List<CoffeeEntity> findBySugarCount(int sugarCount);
	
	List<CoffeeEntity> findByWithMilk(Boolean withMilk);
	
	CoffeeEntity findByCoffeeId(long coffeeId);
}
