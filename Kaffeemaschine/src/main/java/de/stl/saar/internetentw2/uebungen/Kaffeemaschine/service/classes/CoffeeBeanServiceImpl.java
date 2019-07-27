package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.CoffeeBean;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeBeanRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CoffeeBeanService;

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

	@Override
	public void saveCoffeeBean(CoffeeBean coffeeBean) {
		this.coffeeBeanRepository.save((CoffeeBeanImpl)coffeeBean);
	}

	@Override
	public void deleteCoffeeBean(CoffeeBean coffeeBean) {
		this.coffeeBeanRepository.delete((CoffeeBeanImpl)coffeeBean);
	}



}
