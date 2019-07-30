package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces;

import java.util.List;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Tea;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;

/**
 * Interface zur Kapselung von Service-Objekten fuer Tee.
 * 
 * @author Michelle Blau, Dominik Goedicke, Johannes Gerwert
 *
 */

public interface TeaService {
	
	Tea createTea(Integer sugarCount, Boolean withMilk, TeaType teaType);

	List<Tea> findAllTeas();

	void saveTea(Tea tea);

	void deleteTea(Tea tea);

	Tea findTeaById(long teaId);


}
