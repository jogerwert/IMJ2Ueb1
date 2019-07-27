package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeImpl;

public interface CoffeeRepository extends CrudRepository<CoffeeImpl, Long> {

	
	List<CoffeeImpl> findByCoffeeBeanEntity(CoffeeBeanImpl coffeeBeanEntity);
	
	List<CoffeeImpl> findBySugarCount(int sugarCount);
	
	List<CoffeeImpl> findByWithMilk(Boolean withMilk);
	
	CoffeeImpl findByCoffeeId(long coffeeId);
}
