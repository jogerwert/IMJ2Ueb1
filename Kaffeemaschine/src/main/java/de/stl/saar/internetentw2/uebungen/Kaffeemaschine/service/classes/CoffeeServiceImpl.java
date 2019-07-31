package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Coffee;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.CoffeeBean;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CoffeeService;

/**
 * Service-Klasse, welche das Kaffee-Repository kapselt.
 * Es werden ausgewaehlte Methoden zum Laden/Speichern/Loeschen
 * von Objekten der Datenbank zur Verfuegung gestellt.
 * 
 * @author Dominik Goedicke, Michelle Blau, Johannes Gerwert
 *
 */

@Service
public class CoffeeServiceImpl implements CoffeeService{
	@Autowired
	private CoffeeRepository coffeeRepository;
	
	@Value("${summary.coffee-bean}")
	private String summaryCoffeeBean;
	
	@Value("${summary.sugar}")
	private String summarySugar;
	
	@Value("${summary.cookies}")
	private String summaryCookies;
	
	@Value("${summary.pieces}")
	private String summaryPieces;
	
	@Value("${summary.with-milk}")
	private String summaryWithMilk;
	
	@Value("${summary.with-chocolate}")
	private String summaryWithChocolate;
	
	@Value("${summary.with-dash}")
	private String summaryWithDash;

	@Override
	public Coffee createCoffee(Integer cookieCount, Integer sugarCount,
			Boolean withDash, Boolean withChocolate, Boolean withMilk,
			CoffeeBean coffeeBean) {
		
		Coffee coffee = new CoffeeEntity(cookieCount, sugarCount, withDash,
				withMilk, withChocolate, coffeeBean);
		
		return coffee;
	}
	
	@Override
	public List<Coffee> findAllCoffees() {
		List<Coffee> coffeeList = new ArrayList<Coffee>();	
		for (Coffee coffee : coffeeRepository.findAll()) {
			coffeeList.add(coffee);
		}
		
		return coffeeList;
	}

	
	/**
	 * Diese Methode speichert/ueberschreibt Kaffee-Objekte in der Datenbank.
	 * Im Falle der Speicherung wird das Kaffee-Objekt mit einer Id ausgestattet.
	 * Die Id ist der Primaerschluessel.
	 * @param coffee - Kaffee-Objekt, dessen coffeeId veraendert wird, sofern es nicht in der DB existiert.
	 */
	@Override
	public void saveCoffee(Coffee coffee) {
		this.coffeeRepository.save((CoffeeEntity)coffee);
	}

	/**
	 * Loescht ein uebergebenes Kaffee-Objekt aus der Datenbank.
	 * @param coffee - Kaffee-Objekt
	 */
	@Override
	public void deleteCoffee(Coffee coffee) {
		this.coffeeRepository.delete((CoffeeEntity)coffee);
	}

	@Override
	public Coffee findCoffeeById(long coffeeId) {
		return this.coffeeRepository.findByCoffeeId(coffeeId);
	}

	/**
	 * Erstellt einen String, der das Kaffee-Objekt zusammenfassend darstellt.
	 * @param coffee - Kaffee-Objekt, das zusammengefasst werden soll
	 */
	@Override
	public String summarizeCoffee(Coffee coffee) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(summaryCoffeeBean + ": " + coffee.getCoffeeBeanEntity().getCoffeeBeanName());
		
		if(coffee.getWithMilk()) {
			sb.append(" - " + summaryWithMilk);
		}
		if(coffee.getWithChocolate()) {
			sb.append(" - " + summaryWithChocolate);
		}
		if(coffee.getWithDash()) {
			sb.append(" - " + summaryWithDash);
		}
		sb.append(" - " + summaryCookies + ": " + coffee.getCookieCount() + " " 
		+ summaryPieces);
		sb.append(" - " + summarySugar + ": " + coffee.getSugarCount() + " " 
		+ summaryPieces);
		
		
		String result = sb.toString();
		return result;
	}


}
