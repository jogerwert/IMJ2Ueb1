package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaTypeImpl;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaTypeRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.TeaTypeService;

@Service
public class TeaTypeServiceImpl implements TeaTypeService{
	@Autowired
	private TeaTypeRepository teaTypeRepository;
	
	
	@Override
	public List<TeaTypeImpl> findByTeaTypeName(String teaTypeName) {
		List<TeaTypeImpl> teaTypeEntity = this.teaTypeRepository.findByTeaTypeName(teaTypeName);
		return teaTypeEntity;
	}

	@Override
	public TeaTypeImpl findByTeaTypeId(long customerId) {
		TeaTypeImpl teaTypeEntity = this.teaTypeRepository.findByTeaTypeId(customerId);
		return teaTypeEntity;
	}
	
	@Override
	public List<TeaTypeImpl> findAllTeaTypes() {
		List<TeaTypeImpl> teaTypeEntities = new ArrayList<TeaTypeImpl>();
		
		for (TeaTypeImpl teaTypeEntity : teaTypeRepository.findAll()) {
			teaTypeEntities.add(teaTypeEntity);
		}
		
		return teaTypeEntities;
	}

	@Override
	public void saveTeaType(TeaTypeImpl teaTypeEntity) {
		teaTypeRepository.save(teaTypeEntity);
	}

	@Override
	public void deleteTeaType(TeaTypeImpl teaTypeEntity) {
		teaTypeRepository.delete(teaTypeEntity);
		
	}

}
