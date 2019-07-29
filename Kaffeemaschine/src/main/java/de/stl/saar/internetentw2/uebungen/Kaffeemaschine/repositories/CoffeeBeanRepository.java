package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.CoffeeBean;

/**
 * Repository-Klasse fuer die Kaffeebohnen-Datenbankobjekte.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

public interface CoffeeBeanRepository extends CrudRepository<CoffeeBeanEntity, Long> {

	/**
	 * Findet alle Kaffeebohnen mit bestimmtem Namen.
	 * @param coffeeBeanName - zu suchender Name.
	 * @return Liste mit gefundenen Kaffeebohnen.
	 */
	List<CoffeeBean> findByCoffeeBeanName(String coffeeBeanName);
	
    /**
     * Findet Kaffebohne anhand ihrer Id in der Datenbank.
     * @param coffeeBeanId - zu suchende Id.
     * @return Die gefundene Kaffeebohne.
     */
	CoffeeBean findByCoffeeBeanId(long coffeeBeanId);
}
