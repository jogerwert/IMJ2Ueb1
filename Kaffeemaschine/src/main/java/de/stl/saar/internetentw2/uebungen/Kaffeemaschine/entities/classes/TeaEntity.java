package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Tea;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.TeaType;

/**
 * Entity-Klasse fuer Tee. Wird von Hibernate verwendet und hat
 * eine unidirektionale n:1-Beziehung zu Teesorten.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

@Entity
public class TeaEntity implements Tea {
    private Long teaId;
    private Integer sugarCount;
    private Boolean withMilk;
    private TeaType teaType;

    protected TeaEntity() {}

    public TeaEntity(Integer sugarCount, Boolean withMilk, TeaType teaTypeEntity) {
		this.sugarCount = sugarCount;
		this.withMilk = withMilk;
		this.teaType = teaTypeEntity;
	}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getTeaId() {
		return teaId;
	}

	public void setTeaId(Long teaId) {
		this.teaId = teaId;
	}

	public Integer getSugarCount() {
		return sugarCount;
	}



	public void setSugarCount(Integer sugarCount) {
		this.sugarCount = sugarCount;
	}



	public Boolean getWithMilk() {
		return withMilk;
	}



	public void setWithMilk(Boolean withMilk) {
		this.withMilk = withMilk;
	}


	@ManyToOne(targetEntity = TeaTypeEntity.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "teaTypeId")
	public TeaType getTeaTypeEntity() {
		return teaType;
	}



	public void setTeaTypeEntity(TeaType teaTypeEntity) {
		this.teaType = teaTypeEntity;
	}

	@Override
	public String toString() {
		return "TeaEntity [teaId=" + teaId + ", sugarCount=" + sugarCount + ", withMilk=" + withMilk + ", teaType="
				+ teaType + "]";
	}


}
