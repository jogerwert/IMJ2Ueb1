package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CocoaImpl;

public interface CocoaService {
	
	
	List<CocoaImpl> findByLowFat(Boolean lowFat);
    
	CocoaImpl findByCocoaId(long cocoaId);

	List<CocoaImpl> findAllCocoas();

	void saveCocoa(CocoaImpl cocoaEntity);
	
	void deleteCocoa(CocoaImpl cocoaEntity);
}
