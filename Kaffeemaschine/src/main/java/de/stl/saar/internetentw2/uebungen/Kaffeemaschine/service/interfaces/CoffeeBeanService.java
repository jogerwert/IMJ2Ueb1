package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanImpl;

public interface CoffeeBeanService {
	
	
	List<CoffeeBeanImpl> findByCoffeeBeanName(String coffeeBeanName);
    
	CoffeeBeanImpl findByCoffeeBeanId(long coffeeBeanId);

	List<CoffeeBeanImpl> findAllCoffeeBeans();

	void saveCoffeeBean(CoffeeBeanImpl coffeeBeanEntity);
	
	void deleteCoffeeBean(CoffeeBeanImpl coffeeBeanEntity);
}
