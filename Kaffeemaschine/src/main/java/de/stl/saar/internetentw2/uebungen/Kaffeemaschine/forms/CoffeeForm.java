package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.forms;

/**
 * Vereinfachte Darstellung von Coffee-Objekten.
 * Wird in html-forms benoetigt.
 * 
 * @author Johannes Gerwert
 *
 */
public class CoffeeForm {

	private int cookieCount;
	private int sugarCount;
	private boolean withDash;
	private boolean withChocolate;
	private boolean withMilk;
	private long coffeeBean;
	
	public int getCookieCount() {
		return cookieCount;
	}
	public void setCookieCount(int cookieCount) {
		this.cookieCount = cookieCount;
	}
	public int getSugarCount() {
		return sugarCount;
	}
	public void setSugarCount(int sugarCount) {
		this.sugarCount = sugarCount;
	}
	public boolean isWithDash() {
		return withDash;
	}
	public void setWithDash(boolean withDash) {
		this.withDash = withDash;
	}
	public boolean isWithChocolate() {
		return withChocolate;
	}
	public void setWithChocolate(boolean withChocolate) {
		this.withChocolate = withChocolate;
	}
	public boolean isWithMilk() {
		return withMilk;
	}
	public void setWithMilk(boolean withMilk) {
		this.withMilk = withMilk;
	}
	public long getCoffeeBean() {
		return coffeeBean;
	}
	public void setCoffeeBean(long coffeeBean) {
		this.coffeeBean = coffeeBean;
	}
}
