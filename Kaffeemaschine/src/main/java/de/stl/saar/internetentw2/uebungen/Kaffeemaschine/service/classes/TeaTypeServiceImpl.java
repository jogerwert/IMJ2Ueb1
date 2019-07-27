package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.TeaTypeEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.TeaTypeRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.TeaTypeService;

@Service
public class TeaTypeServiceImpl implements TeaTypeService{
	@Autowired
	private TeaTypeRepository teaTypeRepository;
	
	
	@Override
	public List<TeaType> findByTeaTypeName(String teaTypeName) {
		List<TeaType> teaType = this.teaTypeRepository.findByTeaTypeName(teaTypeName);
		return teaType;
	}

	@Override
	public TeaType findByTeaTypeId(long customerId) {
		TeaType teaTypeEntity = this.teaTypeRepository.findByTeaTypeId(customerId);
		return teaTypeEntity;
	}
	
	@Override
	public List<TeaType> findAllTeaTypes() {
		List<TeaType> teaTypeList = new ArrayList<TeaType>();
		
		for (TeaType teaType : teaTypeRepository.findAll()) {
			teaTypeList.add(teaType);
		}
		
		return teaTypeList;
	}

	@Override
	public void saveTeaType(TeaType teaTypeEntity) {
		teaTypeRepository.save((TeaTypeEntity)teaTypeEntity);
	}

	@Override
	public void deleteTeaType(TeaType teaTypeEntity) {
		teaTypeRepository.delete((TeaTypeEntity)teaTypeEntity);
		
	}

}
