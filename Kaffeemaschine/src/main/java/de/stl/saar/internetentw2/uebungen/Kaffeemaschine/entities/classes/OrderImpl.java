package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

@Entity
public class OrderImpl {
    private Long orderId;
    private Calendar date;
    private CustomerImpl customerEntity;
    private List<TeaImpl> teaEntityList;
    private List<CoffeeImpl> coffeeEntityList;
    private List<CocoaImpl> cocoaEntityList;

    protected OrderImpl() {}


	
	public OrderImpl(Calendar date, CustomerImpl customerEntity, List<TeaImpl> teaEntityList,
			List<CoffeeImpl> coffeeEntityList, List<CocoaImpl> cocoaEntityList) {
		super();
		this.date = date;
		this.customerEntity = customerEntity;
		this.teaEntityList = teaEntityList;
		this.coffeeEntityList = coffeeEntityList;
		this.cocoaEntityList = cocoaEntityList;
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

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customerId")
	public CustomerImpl getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerImpl customerEntity) {
		this.customerEntity = customerEntity;
	}


	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "teaId")
	public List<TeaImpl> getTeaEntityList() {
		return teaEntityList;
	}



	public void setTeaEntityList(List<TeaImpl> teaEntityList) {
		this.teaEntityList = teaEntityList;
	}


	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "coffeeId")
	public List<CoffeeImpl> getCoffeeEntityList() {
		return coffeeEntityList;
	}



	public void setCoffeeEntityList(List<CoffeeImpl> coffeeEntityList) {
		this.coffeeEntityList = coffeeEntityList;
	}



	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "cocoaId")
	@Fetch(value = FetchMode.SUBSELECT)
	public List<CocoaImpl> getCocoaEntityList() {
		return cocoaEntityList;
	}



	public void setCocoaEntityList(List<CocoaImpl> cocoaEntityList) {
		this.cocoaEntityList = cocoaEntityList;
	}



	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		
		return "OrderEntity [orderId=" + orderId + ", date=" + dateFormat.format(date.getTime()) + ", customerEntity=" + customerEntity
				+ ", teaEntityList=" + teaEntityList + ", coffeeEntityList=" + coffeeEntityList + ", cocoaEntityList="
				+ cocoaEntityList + "]";
	}


}
