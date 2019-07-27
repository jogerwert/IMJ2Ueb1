package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaTypeImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;

public interface TeaTypeRepository extends CrudRepository<TeaTypeImpl, Long> {

	
	List<TeaType> findByTeaTypeName(String teaTypeName);
	
    
	TeaType findByTeaTypeId(long teaTypeId);
}
