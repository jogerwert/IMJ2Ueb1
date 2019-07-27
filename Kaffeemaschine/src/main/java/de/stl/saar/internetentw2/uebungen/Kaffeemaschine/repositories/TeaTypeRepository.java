package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaTypeImpl;

public interface TeaTypeRepository extends CrudRepository<TeaTypeImpl, Long> {

	
	List<TeaTypeImpl> findByTeaTypeName(String teaTypeName);
	
    
	TeaTypeImpl findByTeaTypeId(long teaTypeId);
}
