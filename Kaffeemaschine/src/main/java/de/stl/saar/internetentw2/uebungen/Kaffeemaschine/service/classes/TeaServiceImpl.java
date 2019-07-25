package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.TeaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.TeaService;

@Service
public class TeaServiceImpl implements TeaService{
	@Autowired
	private TeaRepository teaRepository;

	@Override
	public List<TeaEntity> findAllTeas() {
		List<TeaEntity> teaEntities = new ArrayList<TeaEntity>();	
		for (TeaEntity teaEntity : teaRepository.findAll()) {
			teaEntities.add(teaEntity);
		}
		
		return teaEntities;
	}

	@Override
	public void saveTea(TeaEntity teaEntity) {
		teaRepository.save(teaEntity);
		
	}

	@Override
	public void deleteTea(TeaEntity teaEntity) {
		teaRepository.delete(teaEntity);
		
	}

	@Override
	public TeaEntity findTeaById(long teaId) {
		TeaEntity teaEntity = teaRepository.findByTeaId(teaId);
		return teaEntity;
	}
	
	
	

}
