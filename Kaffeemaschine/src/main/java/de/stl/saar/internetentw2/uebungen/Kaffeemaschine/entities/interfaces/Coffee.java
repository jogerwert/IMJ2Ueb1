package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces;

public interface Coffee {

	Long getCoffeeId();

	void setCoffeeId(Long coffeeId);

	Integer getCookieCount();

	void setCookieCount(Integer cookieCount);

	Integer getSugarCount();

	void setSugarCount(Integer sugarCount);

	Boolean getWithDash();

	void setWithDash(Boolean withDash);

	Boolean getWithChocolate();

	void setWithChocolate(Boolean withChocolate);

	Boolean getWithMilk();

	void setWithMilk(Boolean withMilk);

	CoffeeBean getCoffeeBeanEntity();

	void setCoffeeBeanEntity(CoffeeBean coffeeBeanEntity);

}