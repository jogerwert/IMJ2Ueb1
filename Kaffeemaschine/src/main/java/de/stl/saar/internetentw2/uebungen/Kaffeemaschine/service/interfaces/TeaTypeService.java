package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaTypeImpl;

public interface TeaTypeService {
	
	
	List<TeaTypeImpl> findByTeaTypeName(String teaTypeName);
    
	TeaTypeImpl findByTeaTypeId(long teaTypeId);

	List<TeaTypeImpl> findAllTeaTypes();

	void saveTeaType(TeaTypeImpl teaTypeEntity);
	
	void deleteTeaType(TeaTypeImpl teaTypeEntity);
}
