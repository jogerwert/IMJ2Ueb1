package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CoffeeBeanEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeBeanRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CoffeeBeanService;

@Service
public class CoffeeBeanServiceImpl implements CoffeeBeanService{
	@Autowired
	private CoffeeBeanRepository coffeeBeanRepository;
	


	@Override
	public List<CoffeeBeanEntity> findByCoffeeBeanName(String coffeeBeanName) {
		return this.coffeeBeanRepository.findByCoffeeBeanName(coffeeBeanName);
	}

	@Override
	public CoffeeBeanEntity findByCoffeeBeanId(long coffeeBeanId) {
		return this.coffeeBeanRepository.findByCoffeeBeanId(coffeeBeanId);
	}

	@Override
	public List<CoffeeBeanEntity> findAllCoffeeBeans() {
		List<CoffeeBeanEntity> coffeeBeanEntities = new ArrayList<CoffeeBeanEntity>();
		for(CoffeeBeanEntity coffeeBeanEntity : coffeeBeanRepository.findAll()) {
			coffeeBeanEntities.add(coffeeBeanEntity);
		}
		return coffeeBeanEntities;
	}

	@Override
	public void saveCoffeeBean(CoffeeBeanEntity coffeeBeanEntity) {
		this.coffeeBeanRepository.save(coffeeBeanEntity);
	}

	@Override
	public void deleteCoffeeBean(CoffeeBeanEntity coffeeBeanEntity) {
		this.coffeeBeanRepository.delete(coffeeBeanEntity);
	}



}
