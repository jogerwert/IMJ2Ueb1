package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.CoffeeBean;

/**
 * Entity-Klasse fuer Kaffeebohnen. Wird von Hibernate verwendet.
 * @author Dominik Goedicke, Michelle Blau
 *
 */

@Entity
public class CoffeeBeanEntity implements CoffeeBean {
	private Long coffeeBeanId;
	private String coffeeBeanName;
	
	
    protected CoffeeBeanEntity() {}

    public CoffeeBeanEntity(String coffeeBeanName) {
        this.coffeeBeanName = coffeeBeanName;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getCoffeeBeanId() {
		return coffeeBeanId;
	}

	public void setCoffeeBeanId(Long coffeeBeanId) {
		this.coffeeBeanId = coffeeBeanId;
	}

	public String getCoffeeBeanName() {
		return coffeeBeanName;
	}

	public void setCoffeeBeanName(String coffeeBeanName) {
		this.coffeeBeanName = coffeeBeanName;
	}

	@Override
	public String toString() {
		return "CoffeeBeanEntity [coffeeBeanId=" + coffeeBeanId + ", coffeeBeanName=" + coffeeBeanName + "]";
	}




    
    
}
