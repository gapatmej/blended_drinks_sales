package ec.com.andres.builder;

import ec.com.andres.entities.Drink;

public abstract class DrinkBuilder {

	protected Drink drink;
	
	public Drink getDrink() {
		return drink;
	}
	
	public void createDrink() {
		this.drink = new Drink();
	}
	
	public abstract void setName();
	public abstract void setPercentageProfit();
	public abstract void setSize();
	public abstract void setFlavor();
	
}

