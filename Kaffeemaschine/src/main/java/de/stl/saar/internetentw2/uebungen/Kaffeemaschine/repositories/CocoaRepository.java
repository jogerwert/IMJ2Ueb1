package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CocoaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Cocoa;

public interface CocoaRepository extends CrudRepository<CocoaEntity, Long> {

	
	List<Cocoa> findByLowFat(Boolean lowFat);
	
    
	Cocoa findByCocoaId(long cocoaId);
}
