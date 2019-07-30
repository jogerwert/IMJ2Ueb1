package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Coffee;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.CoffeeBean;

/**
 * Interface zur Kapselung von Service-Objekten fuer Kaffee.
 * 
 * @author Michelle Blau, Dominik Goedicke, Johannes Gerwert
 *
 */

public interface CoffeeService {
	
	Coffee createCoffee(Integer cookieCount, Integer sugarCount,
			Boolean withDash, Boolean withChocolate,
			Boolean withMilk, CoffeeBean coffeeBean);

	List<Coffee> findAllCoffees();

	void saveCoffee(Coffee coffee);

	void deleteCoffee(Coffee coffee);

	Coffee findCoffeeById(long coffeeId);


}
