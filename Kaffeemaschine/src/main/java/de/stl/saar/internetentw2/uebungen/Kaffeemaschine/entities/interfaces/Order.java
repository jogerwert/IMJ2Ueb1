package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces;

import java.util.Calendar;
import java.util.List;

/**
 * Interface zur eventuellen Kapselung der Bestellung-Datenbankobjekte.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

public interface Order {

	Long getOrderId();

	void setOrderId(Long orderId);

	Calendar getDate();

	void setDate(Calendar date);

	Customer getCustomer();

	void setCustomer(Customer customer);

	List<Tea> getTeaList();

	void setTeaList(List<Tea> teaList);

	List<Coffee> getCoffeeList();

	void setCoffeeList(List<Coffee> coffeeList);

	List<Cocoa> getCocoaList();

	void setCocoaList(List<Cocoa> cocoaList);

}