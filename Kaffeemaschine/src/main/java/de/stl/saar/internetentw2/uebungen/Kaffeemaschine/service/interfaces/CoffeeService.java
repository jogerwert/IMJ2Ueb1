package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CoffeeEntity;


public interface CoffeeService {

	List<CoffeeEntity> findAllCoffees();

	void saveCoffee(CoffeeEntity coffeeEntity);

	void deleteCoffee(CoffeeEntity coffeeEntity);

	CoffeeEntity findCoffeeById(long coffeeId);


}
