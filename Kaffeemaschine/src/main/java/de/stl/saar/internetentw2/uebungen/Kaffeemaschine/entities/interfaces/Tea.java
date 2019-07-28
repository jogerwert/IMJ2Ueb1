package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces;

/**
 * Interface zur eventuellen Kapselung der Tee-Datenbankobjekte.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

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