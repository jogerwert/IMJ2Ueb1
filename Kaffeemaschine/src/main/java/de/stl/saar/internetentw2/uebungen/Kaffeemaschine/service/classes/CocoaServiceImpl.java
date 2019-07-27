package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CocoaImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Cocoa;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CocoaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CocoaService;

@Service
public class CocoaServiceImpl implements CocoaService{
	@Autowired
	private CocoaRepository cocoaRepository;

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

	@Override
	public void saveCocoa(Cocoa cocoa) {
		cocoaRepository.save((CocoaImpl)cocoa);
		
	}

	@Override
	public void deleteCocoa(Cocoa cocoa) {
		cocoaRepository.delete((CocoaImpl)cocoa);
		
	}



}
