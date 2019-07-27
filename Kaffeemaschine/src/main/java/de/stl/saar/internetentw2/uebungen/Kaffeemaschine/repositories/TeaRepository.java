package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaTypeImpl;

public interface TeaRepository extends CrudRepository<TeaImpl, Long> {

	
	List<TeaImpl> findByTeaTypeEntity(TeaTypeImpl teaTypeEntity);
	
	List<TeaImpl> findBySugarCount(int sugarCount);
	
	List<TeaImpl> findByWithMilk(Boolean withMilk);
	
	TeaImpl findByTeaId(long teaId);
}
