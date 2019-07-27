package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CocoaImpl;

public interface CocoaRepository extends CrudRepository<CocoaImpl, Long> {

	
	List<CocoaImpl> findByLowFat(Boolean lowFat);
	
    
	CocoaImpl findByCocoaId(long cocoaId);
}
