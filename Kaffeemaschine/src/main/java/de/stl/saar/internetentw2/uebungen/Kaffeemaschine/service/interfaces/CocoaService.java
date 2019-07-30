package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Cocoa;

/**
 * Interface zur Kapselung von Service-Objekten fuer Kakao.
 * 
 * @author Michelle Blau, Dominik Goedicke, Johannes Gerwert
 *
 */

public interface CocoaService {
	
	Cocoa createCocoa(Boolean lowFat, Integer cookieCount);
	
	List<Cocoa> findByLowFat(Boolean lowFat);
    
	Cocoa findByCocoaId(long cocoaId);

	List<Cocoa> findAllCocoas();

	void saveCocoa(Cocoa cocoa);
	
	void deleteCocoa(Cocoa cocoa);
}
