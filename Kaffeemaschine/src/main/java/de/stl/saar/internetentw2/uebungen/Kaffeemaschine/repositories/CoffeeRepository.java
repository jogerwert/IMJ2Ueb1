package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Coffee;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.CoffeeBean;

public interface CoffeeRepository extends CrudRepository<CoffeeImpl, Long> {

	
	List<Coffee> findByCoffeeBeanEntity(CoffeeBean coffeeBean);
	
	List<Coffee> findBySugarCount(int sugarCount);
	
	List<Coffee> findByWithMilk(Boolean withMilk);
	
	Coffee findByCoffeeId(long coffeeId);
}
