package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CocoaImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CocoaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CocoaService;

@Service
public class CocoaServiceImpl implements CocoaService{
	@Autowired
	private CocoaRepository cocoaRepository;

	@Override
	public List<CocoaImpl> findByLowFat(Boolean lowFat) {
		return cocoaRepository.findByLowFat(lowFat);
	}

	@Override
	public CocoaImpl findByCocoaId(long cocoaId) {
		return cocoaRepository.findByCocoaId(cocoaId);
	}

	@Override
	public List<CocoaImpl> findAllCocoas() {
		List<CocoaImpl> cocoaEntitiesEntities = new ArrayList<CocoaImpl>();
		
		for (CocoaImpl cocoaEntity : cocoaRepository.findAll()) {
			cocoaEntitiesEntities.add(cocoaEntity);
		}
		
		return cocoaEntitiesEntities;
	}

	@Override
	public void saveCocoa(CocoaImpl cocoaEntity) {
		cocoaRepository.save(cocoaEntity);
		
	}

	@Override
	public void deleteCocoa(CocoaImpl cocoaEntity) {
		cocoaRepository.delete(cocoaEntity);
		
	}

//	@Override
//	public List<TeaTypeEntity> findAllTeaTypes() {

//	}


}
