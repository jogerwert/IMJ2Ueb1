package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CocoaEntity {
	private Long cocoaId;
	private Boolean lowFat;
	private Integer cookieCount;
	
	
    protected CocoaEntity() {}


	public CocoaEntity(Boolean lowFat, Integer cookieCount) {
		super();
		this.lowFat = lowFat;
		this.cookieCount = cookieCount;
	}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getCocoaId() {
		return cocoaId;
	}


	public void setCocoaId(Long cocoaId) {
		this.cocoaId = cocoaId;
	}


	public Boolean getLowFat() {
		return lowFat;
	}


	public void setLowFat(Boolean lowFat) {
		this.lowFat = lowFat;
	}


	public Integer getCookieCount() {
		return cookieCount;
	}


	public void setCookieCount(Integer cookieCount) {
		this.cookieCount = cookieCount;
	}


	@Override
	public String toString() {
		return "CocoaEntity [cocoaId=" + cocoaId + ", lowFat=" + lowFat + ", cookieCount=" + cookieCount + "]";
	}



}
