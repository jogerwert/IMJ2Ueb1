package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Coffee;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.CoffeeBean;

/**
 * Repository-Klasse fuer die Kaffee-Datenbankobjekte.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

public interface CoffeeRepository extends CrudRepository<CoffeeEntity, Long> {

	/**
	 * Findet Kaffee anhand der uebergebenen Kaffeebohne.
	 * @param coffeeBean - zu suchende Kaffeebohne.
	 * @return Liste mit gefundenem Kaffee.
	 */
	List<Coffee> findByCoffeeBeanEntity(CoffeeBean coffeeBean);
	
	/**
	 * Findet Kaffee anhand der uebergenenen Anzahl Zucker.
	 * @param sugarCount - zu suchende Anzahl Zucker.
	 * @return Liste mit gefundenem Kaffee.
	 */
	List<Coffee> findBySugarCount(int sugarCount);
	
	/**
	 * Findet Kaffee anhand des Attributs "mitMilch".
	 * @param withMilk - zu suchendes Attribut.
	 * @return Liste mit gefundenem Kaffee.
	 */
	List<Coffee> findByWithMilk(Boolean withMilk);
	
	/**
	 * Findet Kaffee anhand seiner Id in der Datenbank.
	 * @param coffeeId - zu suchende Id
	 * @return Gefundener Kaffee.
	 */
	Coffee findByCoffeeId(long coffeeId);
}
