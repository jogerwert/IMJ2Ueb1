package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces;

/**
 * Interface zur eventuellen Kapselung der Teesorten-Datenbankobjekte.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

public interface TeaType {

	Long getTeaTypeId();

	void setTeaTypeId(Long teaTypeId);

	String getTeaTypeName();

	void setTeaTypeName(String teaTypeName);

}