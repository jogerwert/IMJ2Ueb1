package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaTypeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;

/**
 * Repository-Klasse fuer die Teesorte-Datenbankobjekte.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

public interface TeaTypeRepository extends CrudRepository<TeaTypeEntity, Long> {

	/**
	 * Findet Teesorten anhand des uebergebenen Namens.
	 * @param teaTypeName - zu suchender Name.
	 * @return Liste mit gefundenen Teesorten.
	 */
	List<TeaType> findByTeaTypeName(String teaTypeName);
	
    /**
     * Findet eine Teesorte anhand ihrer Id in der Datenbank.
     * @param teaTypeId - zu suchende Id.
     * @return Gefundene Teesorte.
     */
	TeaType findByTeaTypeId(long teaTypeId);
}
