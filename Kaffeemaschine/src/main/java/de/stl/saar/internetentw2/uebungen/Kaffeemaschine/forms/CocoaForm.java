package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.forms;

/**
 * Vereinfachte Darstellung von Cocoa-Objekten.
 * Wird in html-forms benoetigt.
 * 
 * @author Johannes Gerwert
 *
 */
public class CocoaForm {

	private boolean lowFat;
	private int cookieCount;
	
	public boolean isLowFat() {
		return lowFat;
	}
	public void setLowFat(boolean lowFat) {
		this.lowFat = lowFat;
	}
	public int getCookieCount() {
		return cookieCount;
	}
	public void setCookieCount(int cookieCount) {
		this.cookieCount = cookieCount;
	}
}
