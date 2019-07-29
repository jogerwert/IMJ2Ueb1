package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces;

/**
 * Interface zur eventuellen Kapselung der Kunden-Datenbankobjekte.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

public interface Customer {
	public Long getCustomerId();
	public void setCustomerId(Long customerId);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
}
