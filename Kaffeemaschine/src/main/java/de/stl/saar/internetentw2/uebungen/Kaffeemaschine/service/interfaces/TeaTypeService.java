package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;

public interface TeaTypeService {
	
	
	List<TeaType> findByTeaTypeName(String teaTypeName);
    
	TeaType findByTeaTypeId(long teaTypeId);

	List<TeaType> findAllTeaTypes();

	void saveTeaType(TeaType teaType);
	
	void deleteTeaType(TeaType teaType);
}
