package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeImpl;


public interface CoffeeService {

	List<CoffeeImpl> findAllCoffees();

	void saveCoffee(CoffeeImpl coffeeEntity);

	void deleteCoffee(CoffeeImpl coffeeEntity);

	CoffeeImpl findCoffeeById(long coffeeId);


}
