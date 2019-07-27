package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeBeanRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CoffeeBeanService;

@Service
public class CoffeeBeanServiceImpl implements CoffeeBeanService{
	@Autowired
	private CoffeeBeanRepository coffeeBeanRepository;
	


	@Override
	public List<CoffeeBeanImpl> findByCoffeeBeanName(String coffeeBeanName) {
		return this.coffeeBeanRepository.findByCoffeeBeanName(coffeeBeanName);
	}

	@Override
	public CoffeeBeanImpl findByCoffeeBeanId(long coffeeBeanId) {
		return this.coffeeBeanRepository.findByCoffeeBeanId(coffeeBeanId);
	}

	@Override
	public List<CoffeeBeanImpl> findAllCoffeeBeans() {
		List<CoffeeBeanImpl> coffeeBeanEntities = new ArrayList<CoffeeBeanImpl>();
		for(CoffeeBeanImpl coffeeBeanEntity : coffeeBeanRepository.findAll()) {
			coffeeBeanEntities.add(coffeeBeanEntity);
		}
		return coffeeBeanEntities;
	}

	@Override
	public void saveCoffeeBean(CoffeeBeanImpl coffeeBeanEntity) {
		this.coffeeBeanRepository.save(coffeeBeanEntity);
	}

	@Override
	public void deleteCoffeeBean(CoffeeBeanImpl coffeeBeanEntity) {
		this.coffeeBeanRepository.delete(coffeeBeanEntity);
	}



}
