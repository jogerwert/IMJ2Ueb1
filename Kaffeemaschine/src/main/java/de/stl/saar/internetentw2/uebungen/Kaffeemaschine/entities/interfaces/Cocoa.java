package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces;

/**
 * Interface zur eventuellen Kapselung der Kakao-Datenbankobjekte.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

public interface Cocoa {

	Long getCocoaId();

	void setCocoaId(Long cocoaId);

	Boolean getLowFat();

	void setLowFat(Boolean lowFat);

	Integer getCookieCount();

	void setCookieCount(Integer cookieCount);

}