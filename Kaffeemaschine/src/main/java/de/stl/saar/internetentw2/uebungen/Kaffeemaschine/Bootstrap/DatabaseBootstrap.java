package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.Bootstrap;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CocoaImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CustomerImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.OrderImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaTypeImpl;
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
		teaTypeRepository.save(new TeaTypeImpl("Schwarzer Tee"));
		teaTypeRepository.save(new TeaTypeImpl("Weißer Tee"));
		teaTypeRepository.save(new TeaTypeImpl("Grüner Tee"));
		teaTypeRepository.save(new TeaTypeImpl("Gelber Tee"));
		teaTypeRepository.save(new TeaTypeImpl("Oolong Tee"));
		teaTypeRepository.save(new TeaTypeImpl("Pu Erh Tee"));
		teaTypeRepository.save(new TeaTypeImpl("Früchtetee"));
		teaTypeRepository.save(new TeaTypeImpl("Kräutertee"));
		
		coffeeBeanRepository.save(new CoffeeBeanImpl("Excelsa"));
		coffeeBeanRepository.save(new CoffeeBeanImpl("Arabica"));
		coffeeBeanRepository.save(new CoffeeBeanImpl("Robusta"));
		coffeeBeanRepository.save(new CoffeeBeanImpl("Maragogype"));
		coffeeBeanRepository.save(new CoffeeBeanImpl("Liberia"));
		coffeeBeanRepository.save(new CoffeeBeanImpl("Kopi Luwak"));

		databaseTestMethod();
		
	}
	
	/**
	 * TODO: Spaeter entfernen. Soll nur sicherstellen, dass die Datenbank funktioniert.
	 */
	private void databaseTestMethod(){

		teaTypeRepository.findAll();
		coffeeBeanRepository.findAll();
		
		CocoaImpl cocoaEntity=new CocoaImpl(true, 5);
		cocoaRepository.save(cocoaEntity);
		
		CoffeeBeanImpl coffeeBeanEntity = new CoffeeBeanImpl("GUGGUGS");
		coffeeBeanRepository.save(coffeeBeanEntity);
		
		CoffeeImpl coffeeEntity = new CoffeeImpl(5, 5, true, true, true, coffeeBeanEntity);
		coffeeRepository.save(coffeeEntity);

		TeaTypeImpl teaTypeEntity= new TeaTypeImpl("ERDBEER");
		teaTypeRepository.save(teaTypeEntity);
		
		TeaImpl teaEntity = new TeaImpl(5, true, teaTypeEntity);
		teaRepository.save(teaEntity);
		
		CustomerImpl customerEntity= new CustomerImpl("Herbert", "Olaf");
		customerRepository.save(customerEntity);
		
		Calendar date = Calendar.getInstance();
		
		List <TeaImpl> teaEntityList= new ArrayList<TeaImpl>();
		teaEntityList.add(teaEntity);
		List <CoffeeImpl> coffeeEntityList= new ArrayList<CoffeeImpl>();
		coffeeEntityList.add(coffeeEntity);
		List <CocoaImpl> cocoaEntityList= new ArrayList<CocoaImpl>();
		cocoaEntityList.add(cocoaEntity);
		
		OrderImpl orderEntity = new OrderImpl(date, customerEntity, teaEntityList, coffeeEntityList, cocoaEntityList);
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
