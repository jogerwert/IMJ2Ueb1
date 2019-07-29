package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces;

/**
 * Interface zur eventuellen Kapselung der Kaffeebohnen-Datenbankobjekte.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

public interface CoffeeBean {

	Long getCoffeeBeanId();

	void setCoffeeBeanId(Long coffeeBeanId);

	String getCoffeeBeanName();

	void setCoffeeBeanName(String coffeeBeanName);

}