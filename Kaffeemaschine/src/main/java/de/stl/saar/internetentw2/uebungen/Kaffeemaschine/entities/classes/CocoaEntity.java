package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Cocoa;

/**
 * Entity-Klasse fuer Kakao. Wird von Hibernate verwendet.
 * @author Dominik Goedicke, Michelle Blau
 *
 */

@Entity
public class CocoaEntity implements Cocoa {
	private Long cocoaId;
	private Boolean lowFat;
	private Integer cookieCount;
	
	
    protected CocoaEntity() {}


	public CocoaEntity(Boolean lowFat, Integer cookieCount) {
		super();
		this.lowFat = lowFat;
		this.cookieCount = cookieCount;
	}


    @Override
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getCocoaId() {
		return cocoaId;
	}



	@Override
	public void setCocoaId(Long cocoaId) {
		this.cocoaId = cocoaId;
	}



	@Override
	public Boolean getLowFat() {
		return lowFat;
	}



	@Override
	public void setLowFat(Boolean lowFat) {
		this.lowFat = lowFat;
	}



	@Override
	public Integer getCookieCount() {
		return cookieCount;
	}



	@Override
	public void setCookieCount(Integer cookieCount) {
		this.cookieCount = cookieCount;
	}


	@Override
	public String toString() {
		return "CocoaEntity [cocoaId=" + cocoaId + ", lowFat=" + lowFat + ", cookieCount=" + cookieCount + "]";
	}






}
