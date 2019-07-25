package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoffeeBeanEntity {
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
