package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Tea;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;

public interface TeaRepository extends CrudRepository<TeaEntity, Long> {

	
	List<Tea> findByTeaTypeEntity(TeaType teaType);
	
	List<Tea> findBySugarCount(int sugarCount);
	
	List<Tea> findByWithMilk(Boolean withMilk);
	
	Tea findByTeaId(long teaId);
}
