package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Tea;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;

/**
 * Repository-Klasse fuer die Tee-Datenbankobjekte.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

public interface TeaRepository extends CrudRepository<TeaEntity, Long> {

	/**
	 * Findet Tee anhand der uebergebenen Teesorte.
	 * @param teaType - zu suchende Teesorte.
	 * @return Liste mit gefundenen Tees.
	 */
	List<Tea> findByTeaTypeEntity(TeaType teaType);
	
	
	/**
	 * Findet Tee anhand der uebergebenen Anzahl Zucker.
	 * @param sugarCount - zu suchende Anzahl Zucker.
	 * @return Liste mit gefundenen Tees.
	 */
	List<Tea> findBySugarCount(int sugarCount);
	
	/**
	 * Findet Tee anhand des Attributs "mitMilch".
	 * @param withMilk - zu suchendes Attribut.
	 * @return Liste mit gefundenen Tees.
	 */
	List<Tea> findByWithMilk(Boolean withMilk);
	
	/**
	 * Findet Tee anhand seiner Id in der Datenbank.
	 * @param teaId - zu suchende Id.
	 * @return Der gefundene Tee.
	 */
	Tea findByTeaId(long teaId);
}
