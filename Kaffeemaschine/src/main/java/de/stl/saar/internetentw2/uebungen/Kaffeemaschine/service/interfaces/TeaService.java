package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Tea;


public interface TeaService {

	List<Tea> findAllTeas();

	void saveTea(Tea tea);

	void deleteTea(Tea tea);

	Tea findTeaById(long teaId);


}
