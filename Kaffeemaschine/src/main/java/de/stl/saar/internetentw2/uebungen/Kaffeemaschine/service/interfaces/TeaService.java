package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaImpl;


public interface TeaService {

	List<TeaImpl> findAllTeas();

	void saveTea(TeaImpl teaEntity);

	void deleteTea(TeaImpl teaEntity);

	TeaImpl findTeaById(long teaId);


}
