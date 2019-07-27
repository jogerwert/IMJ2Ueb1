package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Tea;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.TeaService;

@Service
public class TeaServiceImpl implements TeaService{
	@Autowired
	private TeaRepository teaRepository;

	@Override
	public List<Tea> findAllTeas() {
		List<Tea> teaList = new ArrayList<Tea>();	
		for (Tea tea : teaRepository.findAll()) {
			teaList.add(tea);
		}
		
		return teaList;
	}

	@Override
	public void saveTea(Tea tea) {
		teaRepository.save((TeaEntity)tea);
		
	}

	@Override
	public void deleteTea(Tea tea) {
		teaRepository.delete((TeaEntity)tea);
		
	}

	@Override
	public Tea findTeaById(long teaId) {
		Tea teaEntity = teaRepository.findByTeaId(teaId);
		return teaEntity;
	}
	
	
	

}
