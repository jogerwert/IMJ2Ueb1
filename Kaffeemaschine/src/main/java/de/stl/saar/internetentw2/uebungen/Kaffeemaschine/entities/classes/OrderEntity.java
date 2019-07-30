package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes;


import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Cocoa;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Coffee;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Order;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Tea;

/**
 * Entity-Klasse fuer Bestellungen. Wird von Hibernate verwendet.
 * Es gibt folgende unidirektionale n:m-Beziehungen:
 * - OrderEntity --- TeaEntity
 * - OrderEntity --- CocoaEntity
 * - OrderEntity --- CoffeeEntity
 * 
 * Ebenso gibt es eine unidirektionale n:1-Beziehung zur Klasse CustomerEntity.
 * 
 * @author Dominik Goedicke, Michelle Blau
 *
 */

@Entity
public class OrderEntity implements Order {
    private Long orderId;
    private Calendar date;
    private Customer customer;
    private List<Tea> teaList;
    private List<Coffee> coffeeList;
    private List<Cocoa> cocoaList;

    protected OrderEntity() {}


	
	public OrderEntity(Calendar date, Customer customer, List<Tea> teaList,
			List<Coffee> coffeeList, List<Cocoa> cocoaList) {
		super();
		this.date = date;
		this.customer = customer;
		this.teaList = teaList;
		this.coffeeList = coffeeList;
		this.cocoaList = cocoaList;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	@ManyToOne(targetEntity = CustomerEntity.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "customerId")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@ManyToMany(targetEntity = TeaEntity.class,  fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "teaId")
	public List<Tea> getTeaList() {
		return teaList;
	}



	public void setTeaList(List<Tea> teaList) {
		this.teaList = teaList;
	}


	@ManyToMany(targetEntity = CoffeeEntity.class,  fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "coffeeId")
	public List<Coffee> getCoffeeList() {
		return coffeeList;
	}



	public void setCoffeeList(List<Coffee> coffeeList) {
		this.coffeeList = coffeeList;
	}


	@ManyToMany(targetEntity = CocoaEntity.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "cocoaId")
	@Fetch(value = FetchMode.SUBSELECT)
	public List<Cocoa> getCocoaList() {
		return cocoaList;
	}



	public void setCocoaList(List<Cocoa> cocoaList) {
		this.cocoaList = cocoaList;
	}



	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", date=" + date + ", customer=" + customer + ", teaList=" + teaList
				+ ", coffeeList=" + coffeeList + ", cocoaList=" + cocoaList + "]";
	}




}
