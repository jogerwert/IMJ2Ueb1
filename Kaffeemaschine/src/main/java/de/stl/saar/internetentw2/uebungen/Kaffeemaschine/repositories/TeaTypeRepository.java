package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.TeaTypeEntity;

public interface TeaTypeRepository extends CrudRepository<TeaTypeEntity, Long> {

	
	List<TeaTypeEntity> findByTeaTypeName(String teaTypeName);
	
    
	TeaTypeEntity findByTeaTypeId(long teaTypeId);
}
