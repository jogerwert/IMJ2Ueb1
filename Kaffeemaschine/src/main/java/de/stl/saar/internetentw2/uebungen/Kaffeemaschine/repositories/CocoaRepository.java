package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CocoaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Cocoa;

/**
 * Repository-Klasse fuer die Kakao-Datenbankobjekte.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

public interface CocoaRepository extends CrudRepository<CocoaEntity, Long> {

	/**
	 * Findet Kakao anhand des "fettarm"-Attributs.
	 * @param lowFat - zu suchendes Attribut.
	 * @return Eine Liste mit gefundenen Kakaos.
	 */
	List<Cocoa> findByLowFat(Boolean lowFat);
	
    /**
     * Findet Kakao anhand seiner Id in der Datenbank.
     * @param cocoaId - zu suchende Id.
     * @return Der gefundene Kakao.
     */
	Cocoa findByCocoaId(long cocoaId);
}
