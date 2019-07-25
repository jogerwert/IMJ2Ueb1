package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TeaEntity {
    private Long teaId;
    private Integer sugarCount;
    private Boolean withMilk;
    private TeaTypeEntity teaTypeEntity;

    protected TeaEntity() {}

    public TeaEntity(Integer sugarCount, Boolean withMilk, TeaTypeEntity teaTypeEntity) {
		this.sugarCount = sugarCount;
		this.withMilk = withMilk;
		this.teaTypeEntity = teaTypeEntity;
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


	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "teaTypeId")
	public TeaTypeEntity getTeaTypeEntity() {
		return teaTypeEntity;
	}



	public void setTeaTypeEntity(TeaTypeEntity teaTypeEntity) {
		this.teaTypeEntity = teaTypeEntity;
	}



	@Override
	public String toString() {
		return "TeaEntity [teaId=" + teaId + ", sugarCount=" + sugarCount + ", withMilk=" + withMilk
				+ ", teaTypeEntity=" + teaTypeEntity + "]";
	}


}
