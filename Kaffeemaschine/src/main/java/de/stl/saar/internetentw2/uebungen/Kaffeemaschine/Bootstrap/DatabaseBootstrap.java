package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.Bootstrap;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CocoaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CustomerEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaTypeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Cocoa;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Tea;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CocoaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeBeanRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CustomerRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.OrderRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaTypeRepository;

/**
 * Initialisiert die Datenbank mit Teesorten und Kaffeebohnen.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

@Component
public class DatabaseBootstrap implements 
				ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private TeaTypeRepository teaTypeRepository;
	@Autowired
	private CoffeeBeanRepository coffeeBeanRepository;
	@Autowired
	private TeaRepository teaRepository;
	@Autowired
	private CoffeeRepository coffeeRepository;
	@Autowired
	private CocoaRepository cocoaRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;
	

	
	@Override
	public void onApplicationEvent(
			ContextRefreshedEvent event) {
		initializeDatabase();
	}
	
	public void initializeDatabase() {
		teaTypeRepository.save(new TeaTypeEntity("Schwarzer Tee"));
		teaTypeRepository.save(new TeaTypeEntity("Weißer Tee"));
		teaTypeRepository.save(new TeaTypeEntity("Grüner Tee"));
		teaTypeRepository.save(new TeaTypeEntity("Gelber Tee"));
		teaTypeRepository.save(new TeaTypeEntity("Oolong Tee"));
		teaTypeRepository.save(new TeaTypeEntity("Pu Erh Tee"));
		teaTypeRepository.save(new TeaTypeEntity("Früchtetee"));
		teaTypeRepository.save(new TeaTypeEntity("Kräutertee"));
		
		coffeeBeanRepository.save(new CoffeeBeanEntity("Excelsa"));
		coffeeBeanRepository.save(new CoffeeBeanEntity("Arabica"));
		coffeeBeanRepository.save(new CoffeeBeanEntity("Robusta"));
		coffeeBeanRepository.save(new CoffeeBeanEntity("Maragogype"));
		coffeeBeanRepository.save(new CoffeeBeanEntity("Liberia"));
		coffeeBeanRepository.save(new CoffeeBeanEntity("Kopi Luwak"));

		databaseTestMethod();
		
	}
	
	/**
	 * TODO: Spaeter entfernen. Soll nur sicherstellen, dass die Datenbank funktioniert.
	 */
	private void databaseTestMethod(){

		teaTypeRepository.findAll();
		coffeeBeanRepository.findAll();
		
		CocoaEntity cocoaEntity=new CocoaEntity(true, 5);
		cocoaRepository.save(cocoaEntity);
		
		CoffeeBeanEntity coffeeBeanEntity = new CoffeeBeanEntity("GUGGUGS");
		coffeeBeanRepository.save(coffeeBeanEntity);
		

		TeaTypeEntity teaTypeEntity= new TeaTypeEntity("ERDBEER");
		teaTypeRepository.save(teaTypeEntity);
		
		TeaEntity teaEntity = new TeaEntity(5, true, teaTypeEntity);
		teaRepository.save(teaEntity);
		
		CustomerEntity customerEntity= new CustomerEntity("Herbert", "Olaf");
		customerRepository.save(customerEntity);
		
		Calendar date = Calendar.getInstance();
		
		List <Tea> teaEntityList= new ArrayList<Tea>();
		teaEntityList.add(teaEntity);

		List <Cocoa> cocoaEntityList= new ArrayList<Cocoa>();
		cocoaEntityList.add(cocoaEntity);
		
//
//		List<CoffeeBean> beans= new ArrayList<CoffeeBean>();
//		
//		CoffeeBean b1;
//		CoffeeBean b2;
//		b1 = coffeeBeanRepository.findByCoffeeBeanId(coffeeBeanEntity.getCoffeeBeanId());
//		b2 = coffeeBeanRepository.findByCoffeeBeanId(coffeeBeanEntity.getCoffeeBeanId());
//
//		CoffeeEntity coffeeEntity1 = new CoffeeEntity(5, 5, false, true, true, b1);
//		coffeeRepository.save(coffeeEntity1);
//		CoffeeEntity coffeeEntity2 = new CoffeeEntity(5, 5, false, true, true, b2);
//		coffeeRepository.save(coffeeEntity2);
//		
//		List <Coffee> coffeeEntityList= new ArrayList<Coffee>();
//		coffeeEntityList.add(coffeeEntity1);
//		coffeeEntityList.add(coffeeEntity2);
//		
//		OrderEntity orderEntity = new OrderEntity(date, customerEntity, teaEntityList, coffeeEntityList, cocoaEntityList);
//		
//		orderRepository.save(orderEntity);
//		orderRepository.save(orderEntity);
		
		

	}
}
