package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CocoaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.CocoaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CocoaService;

@Service
public class CocoaServiceImpl implements CocoaService{
	@Autowired
	private CocoaRepository cocoaRepository;

	@Override
	public List<CocoaEntity> findByLowFat(Boolean lowFat) {
		return cocoaRepository.findByLowFat(lowFat);
	}

	@Override
	public CocoaEntity findByCocoaId(long cocoaId) {
		return cocoaRepository.findByCocoaId(cocoaId);
	}

	@Override
	public List<CocoaEntity> findAllCocoas() {
		List<CocoaEntity> cocoaEntitiesEntities = new ArrayList<CocoaEntity>();
		
		for (CocoaEntity cocoaEntity : cocoaRepository.findAll()) {
			cocoaEntitiesEntities.add(cocoaEntity);
		}
		
		return cocoaEntitiesEntities;
	}

	@Override
	public void saveCocoa(CocoaEntity cocoaEntity) {
		cocoaRepository.save(cocoaEntity);
		
	}

	@Override
	public void deleteCocoa(CocoaEntity cocoaEntity) {
		cocoaRepository.delete(cocoaEntity);
		
	}

//	@Override
//	public List<TeaTypeEntity> findAllTeaTypes() {

//	}


}
