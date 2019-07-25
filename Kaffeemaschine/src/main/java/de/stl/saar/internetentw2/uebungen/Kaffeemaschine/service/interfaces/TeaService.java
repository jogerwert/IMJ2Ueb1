package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.TeaEntity;


public interface TeaService {

	List<TeaEntity> findAllTeas();

	void saveTea(TeaEntity teaEntity);

	void deleteTea(TeaEntity teaEntity);

	TeaEntity findTeaById(long teaId);


}
