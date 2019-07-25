package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.Bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CocoaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CoffeeBeanEntity;
//import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.CoffeeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.TeaTypeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CocoaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeBeanRepository;
//import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaTypeRepository;


@Component
public class DatabaseBootstrap implements 
				ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private TeaTypeRepository teaTypeRepository;
	@Autowired
	private CoffeeBeanRepository coffeeBeanRepository;
//	@Autowired
//	private CoffeeRepository coffeeRepository;
	@Autowired
	private CocoaRepository cocoaRepository;

	
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
		
//		CoffeeBeanEntity test= new CoffeeBeanEntity("herbert"); 
//		coffeeBeanRepository.save(test);
//		
//		CoffeeEntity entity = new CoffeeEntity(5, 5, true, true, true, test);
//		coffeeRepository.save(entity);
//		System.out.println(entity);
//		
		coffeeBeanRepository.save(new CoffeeBeanEntity("Excelsa"));
		coffeeBeanRepository.save(new CoffeeBeanEntity("Arabica"));
		coffeeBeanRepository.save(new CoffeeBeanEntity("Robusta"));
		coffeeBeanRepository.save(new CoffeeBeanEntity("Maragogype"));
		coffeeBeanRepository.save(new CoffeeBeanEntity("Liberia"));
		coffeeBeanRepository.save(new CoffeeBeanEntity("Kopi Luwak"));

		CocoaEntity cocoaEntity=new CocoaEntity(true, 5);
		cocoaRepository.save(cocoaEntity);
		System.out.println(cocoaEntity);
		System.out.println(cocoaRepository.findByLowFat(true));
		cocoaRepository.delete(cocoaEntity);
		System.out.println(cocoaRepository.findByLowFat(true));
		
	}
}
