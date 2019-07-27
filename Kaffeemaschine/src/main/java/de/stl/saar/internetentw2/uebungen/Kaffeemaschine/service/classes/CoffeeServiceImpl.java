package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Coffee;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CoffeeService;

@Service
public class CoffeeServiceImpl implements CoffeeService{
	@Autowired
	private CoffeeRepository coffeeRepository;

	@Override
	public List<Coffee> findAllCoffees() {
		List<Coffee> coffeeList = new ArrayList<Coffee>();	
		for (Coffee coffee : coffeeRepository.findAll()) {
			coffeeList.add(coffee);
		}
		
		return coffeeList;
	}

	@Override
	public void saveCoffee(Coffee coffee) {
		this.coffeeRepository.save((CoffeeEntity)coffee);
	}

	@Override
	public void deleteCoffee(Coffee coffee) {
		this.coffeeRepository.delete((CoffeeEntity)coffee);
	}

	@Override
	public Coffee findCoffeeById(long coffeeId) {
		return this.coffeeRepository.findByCoffeeId(coffeeId);
	}



}
