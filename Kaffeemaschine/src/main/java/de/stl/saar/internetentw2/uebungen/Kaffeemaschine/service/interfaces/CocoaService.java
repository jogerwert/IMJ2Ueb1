package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CocoaEntity;

public interface CocoaService {
	
	
	List<CocoaEntity> findByLowFat(Boolean lowFat);
    
	CocoaEntity findByCocoaId(long cocoaId);

	List<CocoaEntity> findAllCocoas();

	void saveCocoa(CocoaEntity cocoaEntity);
	
	void deleteCocoa(CocoaEntity cocoaEntity);
}
