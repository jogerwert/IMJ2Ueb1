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
public class OrderEntity {
    private Long orderId;
    private Calendar date;
    private CustomerEntity customerEntity;
    private List<TeaEntity> teaEntityList;
    private List<CoffeeEntity> coffeeEntityList;
    private List<CocoaEntity> cocoaEntityList;

    protected OrderEntity() {}


	
	public OrderEntity(Calendar date, CustomerEntity customerEntity, List<TeaEntity> teaEntityList,
			List<CoffeeEntity> coffeeEntityList, List<CocoaEntity> cocoaEntityList) {
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
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}


	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "teaId")
	public List<TeaEntity> getTeaEntityList() {
		return teaEntityList;
	}



	public void setTeaEntityList(List<TeaEntity> teaEntityList) {
		this.teaEntityList = teaEntityList;
	}


	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "coffeeId")
	public List<CoffeeEntity> getCoffeeEntityList() {
		return coffeeEntityList;
	}



	public void setCoffeeEntityList(List<CoffeeEntity> coffeeEntityList) {
		this.coffeeEntityList = coffeeEntityList;
	}



	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "cocoaId")
	@Fetch(value = FetchMode.SUBSELECT)
	public List<CocoaEntity> getCocoaEntityList() {
		return cocoaEntityList;
	}



	public void setCocoaEntityList(List<CocoaEntity> cocoaEntityList) {
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
