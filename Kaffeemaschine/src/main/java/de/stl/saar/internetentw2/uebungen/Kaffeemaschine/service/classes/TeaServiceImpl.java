package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Tea;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.TeaService;

/**
 * Service-Klasse, welche das Tee-Repository kapselt.
 * Es werden ausgewaehlte Methoden zum Laden/Speichern/Loeschen
 * von Objekten der Datenbank zur Verfuegung gestellt.
 * 
 * @author Dominik Goedicke, Michelle Blau, Johannes Gerwert
 *
 */

@Service
public class TeaServiceImpl implements TeaService{
	@Autowired
	private TeaRepository teaRepository;
	
	@Value("${summary.tea-type}")
	private String summaryTeaType;
	
	@Value("${summary.sugar}")
	private String summarySugar;
	
	@Value("${summary.pieces}")
	private String summaryPieces;
	
	@Value("${summary.with-milk}")
	private String summaryWithMilk;
	
	@Override
	public Tea createTea(Integer sugarCount, Boolean withMilk, TeaType teaType) {
		Tea tea = new TeaEntity(sugarCount, withMilk, teaType);
		
		return tea;
	}

	@Override
	public List<Tea> findAllTeas() {
		List<Tea> teaList = new ArrayList<Tea>();	
		for (Tea tea : teaRepository.findAll()) {
			teaList.add(tea);
		}
		
		return teaList;
	}

	
	/**
	 * Diese Methode speichert/ueberschreibt Tee-Objekte in der Datenbank.
	 * Im Falle der Speicherung wird das Tee-Objekt mit einer Id ausgestattet.
	 * Die Id ist der Primaerschluessel.
	 * @param tea - Tee-Objekt, dessen teaId veraendert wird, sofern es nicht in der DB existiert.
	 */
	@Override
	public void saveTea(Tea tea) {
		teaRepository.save((TeaEntity)tea);
		
	}

	/**
	 * Loescht ein uebergebenes Tee-Objekt aus der Datenbank.
	 * @param tea - Tee-Objekt
	 */
	@Override
	public void deleteTea(Tea tea) {
		teaRepository.delete((TeaEntity)tea);
		
	}

	@Override
	public Tea findTeaById(long teaId) {
		Tea teaEntity = teaRepository.findByTeaId(teaId);
		return teaEntity;
	}
	
	/**
	 * Erstellt einen String, der das Tee-Objekt zusammenfassend darstellt.
	 * @param tea - Tee-Objekt, das zusammengefasst werden soll
	 */
	@Override
	public String summarizeTea(Tea tea) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(summaryTeaType + ": " + tea.getTeaTypeEntity().getTeaTypeName());
		
		if (tea.getWithMilk()) {
			sb.append(" - " + summaryWithMilk);
		}
		sb.append(" - " + summarySugar + ": " + tea.getSugarCount() + " " 
		+ summaryPieces);
		
		String result = sb.toString();
		return result;
	}
	

}
