package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CoffeeImpl {
    private Long coffeeId;
    private Integer cookieCount;
    private Integer sugarCount;
    private Boolean withDash;
    private Boolean withChocolate;
    private Boolean withMilk;
    private CoffeeBeanImpl coffeeBeanEntity;

    protected CoffeeImpl() {}

	public CoffeeImpl(Integer cookieCount, Integer sugarCount, Boolean withDash, Boolean withChocolate,
			Boolean withMilk, CoffeeBeanImpl coffeeBeanEntity) {
		super();
		this.cookieCount = cookieCount;
		this.sugarCount = sugarCount;
		this.withDash = withDash;
		this.withChocolate = withChocolate;
		this.withMilk = withMilk;
		this.coffeeBeanEntity = coffeeBeanEntity;
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(Long coffeeId) {
		this.coffeeId = coffeeId;
	}

	public Integer getCookieCount() {
		return cookieCount;
	}

	public void setCookieCount(Integer cookieCount) {
		this.cookieCount = cookieCount;
	}

	public Integer getSugarCount() {
		return sugarCount;
	}

	public void setSugarCount(Integer sugarCount) {
		this.sugarCount = sugarCount;
	}

	public Boolean getWithDash() {
		return withDash;
	}

	public void setWithDash(Boolean withDash) {
		this.withDash = withDash;
	}

	public Boolean getWithChocolate() {
		return withChocolate;
	}

	public void setWithChocolate(Boolean withChocolate) {
		this.withChocolate = withChocolate;
	}

	public Boolean getWithMilk() {
		return withMilk;
	}

	public void setWithMilk(Boolean withMilk) {
		this.withMilk = withMilk;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "coffeeBeanId")
	public CoffeeBeanImpl getCoffeeBeanEntity() {
		return coffeeBeanEntity;
	}

	public void setCoffeeBeanEntity(CoffeeBeanImpl coffeeBeanEntity) {
		this.coffeeBeanEntity = coffeeBeanEntity;
	}

	@Override
	public String toString() {
		return "CoffeeEntity [coffeeId=" + coffeeId + ", cookieCount=" + cookieCount + ", sugarCount=" + sugarCount
				+ ", withDash=" + withDash + ", withChocolate=" + withChocolate + ", withMilk=" + withMilk
				+ ", coffeeBeanEntity=" + coffeeBeanEntity + "]";
	}

}
