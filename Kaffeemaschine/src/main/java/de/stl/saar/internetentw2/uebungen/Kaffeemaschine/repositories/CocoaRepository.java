package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CocoaEntity;

public interface CocoaRepository extends CrudRepository<CocoaEntity, Long> {

	
	List<CocoaEntity> findByLowFat(Boolean lowFat);
	
    
	CocoaEntity findByCocoaId(long cocoaId);
}
