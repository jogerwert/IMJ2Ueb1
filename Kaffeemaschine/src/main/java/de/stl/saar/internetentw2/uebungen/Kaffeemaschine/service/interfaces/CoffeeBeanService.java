package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.CoffeeBean;

public interface CoffeeBeanService {
	
	
	List<CoffeeBean> findByCoffeeBeanName(String coffeeBeanName);
    
	CoffeeBean findByCoffeeBeanId(long coffeeBeanId);

	List<CoffeeBean> findAllCoffeeBeans();

	void saveCoffeeBean(CoffeeBean coffeeBean);
	
	void deleteCoffeeBean(CoffeeBean coffeeBean);
}
