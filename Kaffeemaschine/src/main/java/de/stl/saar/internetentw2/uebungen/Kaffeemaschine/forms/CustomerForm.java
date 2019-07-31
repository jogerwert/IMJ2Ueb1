package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.forms;

/**
 * Vereinfachte Darstellung von Customer-Objekten.
 * Wird in html-forms benoetigt.
 * 
 * @author Johannes Gerwert
 *
 */
public class CustomerForm {

	private String firstName;
	private String lastName;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
