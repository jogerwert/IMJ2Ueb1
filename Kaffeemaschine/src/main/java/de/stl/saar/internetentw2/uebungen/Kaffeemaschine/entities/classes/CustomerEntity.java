package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;

/**
 * Entity-Klasse fuer Kunden. Wird von Hibernate verwendet.
 * 
 * @author Johannes Gerwert, Dominik Goedicke, Michelle Blau
 *
 */

@Entity
public class CustomerEntity implements Customer {
    private Long customerId;
    private String firstName;
    private String lastName;

    protected CustomerEntity() {}

    public CustomerEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Override
	public Long getCustomerId() {
		return customerId;
	}

    @Override
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
    


    @Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

    @Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    @Override
	public String getLastName() {
		return lastName;
	}

    @Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    

}