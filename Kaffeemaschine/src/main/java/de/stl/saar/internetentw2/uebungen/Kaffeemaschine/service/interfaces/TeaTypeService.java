package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;

/**
 * Interface zur Kapselung von Service-Objekten fuer Teesorten.
 * 
 * @author Michelle Blau, Dominik Goedicke
 *
 */

public interface TeaTypeService {
	
	
	List<TeaType> findByTeaTypeName(String teaTypeName);
    
	TeaType findByTeaTypeId(long teaTypeId);

	List<TeaType> findAllTeaTypes();

	void saveTeaType(TeaType teaType);
	
	void deleteTeaType(TeaType teaType);
}
