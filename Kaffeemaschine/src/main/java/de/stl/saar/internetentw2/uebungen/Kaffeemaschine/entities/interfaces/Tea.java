package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces;

public interface Tea {

	Long getTeaId();

	void setTeaId(Long teaId);

	Integer getSugarCount();

	void setSugarCount(Integer sugarCount);

	Boolean getWithMilk();

	void setWithMilk(Boolean withMilk);

	TeaType getTeaTypeEntity();

	void setTeaTypeEntity(TeaType teaTypeEntity);

}