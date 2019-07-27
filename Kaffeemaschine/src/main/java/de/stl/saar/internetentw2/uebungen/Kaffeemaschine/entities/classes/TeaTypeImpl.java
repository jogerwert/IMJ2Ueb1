package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;

@Entity
public class TeaTypeImpl implements TeaType {
	private Long teaTypeId;
	private String teaTypeName;
	
	
    protected TeaTypeImpl() {}

    public TeaTypeImpl(String teaTypeName) {
        this.teaTypeName = teaTypeName;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getTeaTypeId() {
		return teaTypeId;
	}
    
	public void setTeaTypeId(Long teaTypeId) {
		this.teaTypeId = teaTypeId;
	}

	public String getTeaTypeName() {
		return teaTypeName;
	}

	public void setTeaTypeName(String teaTypeName) {
		this.teaTypeName = teaTypeName;
	}

	@Override
	public String toString() {
		return "TeaTypeImpl [teaTypeId=" + teaTypeId + ", teaTypeName=" + teaTypeName + "]";
	}


    
    
    
}
