package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.Bootstrap;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CocoaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CoffeeBeanEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CoffeeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CustomerEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.OrderEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.TeaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.TeaTypeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CocoaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeBeanRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CustomerRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.OrderRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaTypeRepository;


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
		
		CoffeeEntity coffeeEntity = new CoffeeEntity(5, 5, true, true, true, coffeeBeanEntity);
		coffeeRepository.save(coffeeEntity);

		TeaTypeEntity teaTypeEntity= new TeaTypeEntity("ERDBEER");
		teaTypeRepository.save(teaTypeEntity);
		
		TeaEntity teaEntity = new TeaEntity(5, true, teaTypeEntity);
		teaRepository.save(teaEntity);
		
		CustomerEntity customerEntity= new CustomerEntity("Herbert", "Olaf");
		customerRepository.save(customerEntity);
		
		Calendar date = Calendar.getInstance();
		
		List <TeaEntity> teaEntityList= new ArrayList<TeaEntity>();
		teaEntityList.add(teaEntity);
		List <CoffeeEntity> coffeeEntityList= new ArrayList<CoffeeEntity>();
		coffeeEntityList.add(coffeeEntity);
		List <CocoaEntity> cocoaEntityList= new ArrayList<CocoaEntity>();
		cocoaEntityList.add(cocoaEntity);
		
		OrderEntity orderEntity = new OrderEntity(date, customerEntity, teaEntityList, coffeeEntityList, cocoaEntityList);
//		System.out.println(orderEntity);
		orderRepository.save(orderEntity);
//		System.out.println(orderEntity);
		
		cocoaEntity.setCookieCount(50000);
		orderEntity.getCocoaEntityList().get(0).setCookieCount(500000);
		
		orderRepository.save(orderEntity);
//		System.out.println(orderRepository.findByCustomerEntity(customerEntity));
//		
//		System.out.println(orderRepository.findByOrderId(orderEntity.getOrderId()));
	}
}
