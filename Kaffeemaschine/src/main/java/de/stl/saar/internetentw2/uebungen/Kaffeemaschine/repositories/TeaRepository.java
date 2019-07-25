package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.TeaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.TeaTypeEntity;

public interface TeaRepository extends CrudRepository<TeaEntity, Long> {

	
	List<TeaEntity> findByTeaTypeEntity(TeaTypeEntity teaTypeEntity);
	
	List<TeaEntity> findBySugarCount(int sugarCount);
	
	List<TeaEntity> findByWithMilk(Boolean withMilk);
	
	TeaEntity findByTeaId(long teaId);
}
