package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.TeaTypeEntity;

public interface TeaTypeService {
	
	
	List<TeaTypeEntity> findByTeaTypeName(String teaTypeName);
    
	TeaTypeEntity findByTeaTypeId(long teaTypeId);

	List<TeaTypeEntity> findAllTeaTypes();

	void saveTeaType(TeaTypeEntity teaTypeEntity);
	
	void deleteTeaType(TeaTypeEntity teaTypeEntity);
}
