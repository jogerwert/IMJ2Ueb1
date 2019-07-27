package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.TeaService;

@Service
public class TeaServiceImpl implements TeaService{
	@Autowired
	private TeaRepository teaRepository;

	@Override
	public List<TeaImpl> findAllTeas() {
		List<TeaImpl> teaEntities = new ArrayList<TeaImpl>();	
		for (TeaImpl teaEntity : teaRepository.findAll()) {
			teaEntities.add(teaEntity);
		}
		
		return teaEntities;
	}

	@Override
	public void saveTea(TeaImpl teaEntity) {
		teaRepository.save(teaEntity);
		
	}

	@Override
	public void deleteTea(TeaImpl teaEntity) {
		teaRepository.delete(teaEntity);
		
	}

	@Override
	public TeaImpl findTeaById(long teaId) {
		TeaImpl teaEntity = teaRepository.findByTeaId(teaId);
		return teaEntity;
	}
	
	
	

}
