package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Coffee;

/**
 * Interface zur Kapselung von Service-Objekten fuer Kaffee.
 * 
 * @author Michelle Blau, Dominik Goedicke
 *
 */

public interface CoffeeService {

	List<Coffee> findAllCoffees();

	void saveCoffee(Coffee coffee);

	void deleteCoffee(Coffee coffee);

	Coffee findCoffeeById(long coffeeId);


}
