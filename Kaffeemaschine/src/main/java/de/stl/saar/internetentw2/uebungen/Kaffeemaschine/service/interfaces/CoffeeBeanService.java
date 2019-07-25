package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CoffeeBeanEntity;

public interface CoffeeBeanService {
	
	
	List<CoffeeBeanEntity> findByCoffeeBeanName(String coffeeBeanName);
    
	CoffeeBeanEntity findByCoffeeBeanId(long coffeeBeanId);

	List<CoffeeBeanEntity> findAllCoffeeBeans();

	void saveCoffeeBean(CoffeeBeanEntity coffeeBeanEntity);
	
	void deleteCoffeeBean(CoffeeBeanEntity coffeeBeanEntity);
}
