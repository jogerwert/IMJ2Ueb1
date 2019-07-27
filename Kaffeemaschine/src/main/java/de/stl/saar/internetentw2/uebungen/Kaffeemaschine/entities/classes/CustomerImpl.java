package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;

@Entity
public class CustomerImpl implements Customer {
    private Long customerId;
    private String firstName;
    private String lastName;

    protected CustomerImpl() {}

    public CustomerImpl(String firstName, String lastName) {
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
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                customerId, firstName, lastName);
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