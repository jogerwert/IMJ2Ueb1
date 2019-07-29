package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.CoffeeBean;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeBeanRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CoffeeBeanService;

/**
 * Service-Klasse, welche das Kaffeebohnen-Repository kapselt.
 * Es werden ausgewaehlte Methoden zum Laden/Speichern/Loeschen
 * von Objekten der Datenbank zur Verfuegung gestellt.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

@Service
public class CoffeeBeanServiceImpl implements CoffeeBeanService{
	@Autowired
	private CoffeeBeanRepository coffeeBeanRepository;
	


	@Override
	public List<CoffeeBean> findByCoffeeBeanName(String coffeeBeanName) {
		return this.coffeeBeanRepository.findByCoffeeBeanName(coffeeBeanName);
	}

	@Override
	public CoffeeBean findByCoffeeBeanId(long coffeeBeanId) {
		return this.coffeeBeanRepository.findByCoffeeBeanId(coffeeBeanId);
	}

	@Override
	public List<CoffeeBean> findAllCoffeeBeans() {
		List<CoffeeBean> coffeeBeanList = new ArrayList<CoffeeBean>();
		for(CoffeeBean coffeeBean : coffeeBeanRepository.findAll()) {
			coffeeBeanList.add(coffeeBean);
		}
		return coffeeBeanList;
	}

	/**
	 * Diese Methode speichert/ueberschreibt Kaffeebohnen-Objekte in der Datenbank.
	 * Im Falle der Speicherung wird das Kaffeebohnen-Objekt mit einer Id ausgestattet.
	 * Die Id ist der Primaerschluessel.
	 * @param coffeeBean - Kaffeebohnen-Objekt, dessen coffeeBeanId veraendert wird, sofern es nicht in der DB existiert.
	 */
	@Override
	public void saveCoffeeBean(CoffeeBean coffeeBean) {
		this.coffeeBeanRepository.save((CoffeeBeanEntity)coffeeBean);
	}

	
	/**
	 * Loescht ein uebergebenes Kaffeebohnen-Objekt aus der Datenbank.
	 * @param coffeeBean - Kaffeebohnen-Objekt
	 */
	@Override
	public void deleteCoffeeBean(CoffeeBean coffeeBean) {
		this.coffeeBeanRepository.delete((CoffeeBeanEntity)coffeeBean);
	}



}
