package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.OrderEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Order;

/**
 * Repository-Klasse fuer die Bestellung-Datenbankobjekte.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

	/**
	 * Findet Bestellungen anhand eines uebergebenen Kunden.
	 * @param customer - der zu suchende Kunde.
	 * @return Liste mit gefundenen Bestellungen.
	 */
	List<Order> findByCustomer(Customer customer);
	
	/**
	 * Findet Bestellungen anhand eines uebergebenen Datums.
	 * @param date - zu suchendes Datum.
	 * @return Liste mit gefundenen Bestellungen.
	 */
	List<Order> findByDate(Calendar date);
	
	/**
	 * Findet eine Bestellung anhand ihrer Id in der Datenbank.
	 * @param orderId - zu suchende Id.
	 * @return Gefundene Bestellung.
	 */
	Order findByOrderId(long orderId);
}
