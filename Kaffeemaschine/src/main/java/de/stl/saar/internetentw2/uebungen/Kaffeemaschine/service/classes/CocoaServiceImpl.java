package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CocoaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Cocoa;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CocoaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CocoaService;

/**
 * Service-Klasse, welche das Kakao-Repository kapselt.
 * Es werden ausgewaehlte Methoden zum Laden/Speichern/Loeschen
 * von Objekten der Datenbank zur Verfuegung gestellt.
 * 
 * @author Dominik Goedicke, Michelle Blau, Johannes Gerwert
 *
 */

@Service
public class CocoaServiceImpl implements CocoaService{
	@Autowired
	private CocoaRepository cocoaRepository;
	
	@Value("${summary.fat-free}")
	private String summaryFatFree;
	
	@Value("${summary.cookies}")
	private String summaryCookies;
	
	@Value("${summary.pieces}")
	private String summaryPieces;
	
	
	
	@Override
	public Cocoa createCocoa(Boolean lowFat, Integer cookieCount) {
		Cocoa cocoa = new CocoaEntity(lowFat, cookieCount);
		
		return cocoa;
	}

	@Override
	public List<Cocoa> findByLowFat(Boolean lowFat) {
		return cocoaRepository.findByLowFat(lowFat);
	}

	@Override
	public Cocoa findByCocoaId(long cocoaId) {
		return cocoaRepository.findByCocoaId(cocoaId);
	}

	@Override
	public List<Cocoa> findAllCocoas() {
		List<Cocoa> cocoaList = new ArrayList<Cocoa>();
		
		for (Cocoa cocoa : cocoaRepository.findAll()) {
			cocoaList.add(cocoa);
		}
		
		return cocoaList;
	}

	/**
	 * Diese Methode speichert/ueberschreibt Kakao-Objekte in der Datenbank.
	 * Im Falle der Speicherung wird das Kakao-Objekt mit einer Id ausgestattet.
	 * Die Id ist der Primaerschluessel.
	 * @param cocoa - Kakao-Objekt, dessen cocoaId veraendert wird, sofern es nicht in der DB existiert.
	 */
	@Override
	public void saveCocoa(Cocoa cocoa) {
		cocoaRepository.save((CocoaEntity)cocoa);
		
	}

	/**
	 * Loescht ein uebergebenes Kakao-Objekt aus der Datenbank.
	 * @param cocoa - Kakao-Objekt
	 */
	@Override
	public void deleteCocoa(Cocoa cocoa) {
		cocoaRepository.delete((CocoaEntity)cocoa);
		
	}
	
	/**
	 * Erstellt einen String, der das Kakao-Objekt zusammenfassend darstellt.
	 * @param cocoa - Kakao-Objekt, das zusammengefasst werden soll
	 */
	@Override
	public String summarizeCocoa(Cocoa cocoa) {
		StringBuilder sb = new StringBuilder();
		
		if(cocoa.getLowFat()) {
			sb.append(summaryFatFree + " - ");
		}
		sb.append(summaryCookies + ": " + cocoa.getCookieCount() + " "
		+ summaryPieces);
		
		
		String result = sb.toString();
		return result;
	}



}
