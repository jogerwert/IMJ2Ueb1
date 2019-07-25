package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CoffeeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CoffeeService;

@Service
public class CoffeeServiceImpl implements CoffeeService{
	@Autowired
	private CoffeeRepository coffeeRepository;

	@Override
	public List<CoffeeEntity> findAllCoffees() {
		List<CoffeeEntity> coffeeEntities = new ArrayList<CoffeeEntity>();	
		for (CoffeeEntity coffeeEntity : coffeeRepository.findAll()) {
			coffeeEntities.add(coffeeEntity);
		}
		
		return coffeeEntities;
	}

	@Override
	public void saveCoffee(CoffeeEntity coffeeEntity) {
		this.coffeeRepository.save(coffeeEntity);
	}

	@Override
	public void deleteCoffee(CoffeeEntity coffeeEntity) {
		this.coffeeRepository.delete(coffeeEntity);
	}

	@Override
	public CoffeeEntity findCoffeeById(long coffeeId) {
		return this.coffeeRepository.findByCoffeeId(coffeeId);
	}



}
