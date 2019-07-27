package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Cocoa;

public interface CocoaService {
	
	
	List<Cocoa> findByLowFat(Boolean lowFat);
    
	Cocoa findByCocoaId(long cocoaId);

	List<Cocoa> findAllCocoas();

	void saveCocoa(Cocoa cocoa);
	
	void deleteCocoa(Cocoa cocoa);
}
