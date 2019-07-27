package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaTypeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaTypeRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.TeaTypeService;

@Service
public class TeaTypeServiceImpl implements TeaTypeService{
	@Autowired
	private TeaTypeRepository teaTypeRepository;
	
	
	@Override
	public List<TeaTypeEntity> findByTeaTypeName(String teaTypeName) {
		List<TeaTypeEntity> teaTypeEntity = this.teaTypeRepository.findByTeaTypeName(teaTypeName);
		return teaTypeEntity;
	}

	@Override
	public TeaTypeEntity findByTeaTypeId(long customerId) {
		TeaTypeEntity teaTypeEntity = this.teaTypeRepository.findByTeaTypeId(customerId);
		return teaTypeEntity;
	}
	
	@Override
	public List<TeaTypeEntity> findAllTeaTypes() {
		List<TeaTypeEntity> teaTypeEntities = new ArrayList<TeaTypeEntity>();
		
		for (TeaTypeEntity teaTypeEntity : teaTypeRepository.findAll()) {
			teaTypeEntities.add(teaTypeEntity);
		}
		
		return teaTypeEntities;
	}

	@Override
	public void saveTeaType(TeaTypeEntity teaTypeEntity) {
		teaTypeRepository.save(teaTypeEntity);
	}

	@Override
	public void deleteTeaType(TeaTypeEntity teaTypeEntity) {
		teaTypeRepository.delete(teaTypeEntity);
		
	}

}
