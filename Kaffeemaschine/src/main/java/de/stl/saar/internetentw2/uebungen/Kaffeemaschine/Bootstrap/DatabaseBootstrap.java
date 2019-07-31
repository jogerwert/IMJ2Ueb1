package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.Bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CoffeeBeanEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaTypeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CoffeeBeanRepository;
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

	}
	

}
