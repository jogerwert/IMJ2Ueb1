package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaTypeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaTypeRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.TeaTypeService;

/**
 * Service-Klasse, welche das Teesorte-Repository kapselt.
 * Es werden ausgewaehlte Methoden zum Laden/Speichern/Loeschen
 * von Objekten der Datenbank zur Verfuegung gestellt.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

@Service
public class TeaTypeServiceImpl implements TeaTypeService{
	@Autowired
	private TeaTypeRepository teaTypeRepository;
	
	
	@Override
	public List<TeaType> findByTeaTypeName(String teaTypeName) {
		List<TeaType> teaType = this.teaTypeRepository.findByTeaTypeName(teaTypeName);
		return teaType;
	}

	@Override
	public TeaType findByTeaTypeId(long customerId) {
		TeaType teaTypeEntity = this.teaTypeRepository.findByTeaTypeId(customerId);
		return teaTypeEntity;
	}
	
	@Override
	public List<TeaType> findAllTeaTypes() {
		List<TeaType> teaTypeList = new ArrayList<TeaType>();
		
		for (TeaType teaType : teaTypeRepository.findAll()) {
			teaTypeList.add(teaType);
		}
		
		return teaTypeList;
	}

	/**
	 * Diese Methode speichert/ueberschreibt Teesorte-Objekte in der Datenbank.
	 * Im Falle der Speicherung wird das Teesorte-Objekt mit einer Id ausgestattet.
	 * Die Id ist der Primaerschluessel.
	 * @param teaType - Teesorte-Objekt, dessen teaTypeId veraendert wird, sofern es nicht in der DB existiert.
	 */
	@Override
	public void saveTeaType(TeaType teaType) {
		teaTypeRepository.save((TeaTypeEntity)teaType);
	}

	
	/**
	 * Loescht ein uebergebenes Teesorte-Objekt aus der Datenbank.
	 * @param teaType - Teesorte-Objekt
	 */
	@Override
	public void deleteTeaType(TeaType teaType) {
		teaTypeRepository.delete((TeaTypeEntity)teaType);
		
	}

}
