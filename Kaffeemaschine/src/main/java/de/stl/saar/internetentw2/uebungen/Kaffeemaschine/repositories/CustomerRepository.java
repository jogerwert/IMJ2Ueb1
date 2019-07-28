package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.CustomerEntity;


/**
 * Die Klasse, welche die Methoden fuer die Datenbankzugriffe enthaelt. Die implementierende
 * Klasse enthaelt jedoch nicht nur die im Interface enthaltenen Methoden.
 * @author christopher, Johannes Gerwert, Michelle Blau, Dominik Goedicke
 *
 */
public interface CustomerRepository extends 
			CrudRepository<CustomerEntity, Long> {
	/**
	 * Sucht Kunden anhand des Nachnamens aus der Datenbank. Dabei ist es moeglich, dass
	 * es mehrere Kunden mit demselben Nachnamen gibt. 
	 * @param name Der Nachname, nach dem gesucht wird.
	 * @return Die Liste mit den gefundenen Kunden.
	 */
    List<CustomerEntity> findByLastName(String name);
    /**
     * Findet einen Kunden anhand des Vor- und Nachnamens. Dabei wird davon ausgegangen,
     * dass es nur einen einzigen Kunden mit dieser Namenskombination gibt.
     * @param firstName Der zu suchende Vorname.
     * @param lastName Der zu suchende Nachname.
     * @return Der gefundene Kunde.
     */
    CustomerEntity findByFirstNameAndLastName(String firstName, 
    		String lastName);

    
    /**
     * Findet einen Kunden anhand seiner Id in der Datenbank.
     * @param customerId - Die zu suchende Id.
     * @return Der gefundene Kunde.
     */
    CustomerEntity findByCustomerId(long customerId);
}