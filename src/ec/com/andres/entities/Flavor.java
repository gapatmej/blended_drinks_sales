package ec.com.andres.entities;

import java.math.BigDecimal;

public class Flavor {

	enum Composition {
		FRUIT(new BigDecimal(50)), ICE(new BigDecimal(30)), CONDENSED_MILK(new BigDecimal(20)),
		SUGAR(new BigDecimal(8)),;

		private BigDecimal value;

		private Composition(BigDecimal value) {
			this.value = value;
		}

		public BigDecimal getValue() {
			return value;
		}
	};
	
	private BigDecimal amountFruitNecesary;
	private BigDecimal amountFruit;
	private BigDecimal amountIce;
	private BigDecimal amountCondensedMilk;
	private BigDecimal amountSugar;
	private Ingredient fruitIngredient;
	
	public BigDecimal getAmountFruitNecesary() {
		return amountFruitNecesary;
	}
	public void setAmountFruitNecesary(BigDecimal amountFruitNecesary) {
		this.amountFruitNecesary = amountFruitNecesary;
	}
	public BigDecimal getAmountFruit() {
		return amountFruit;
	}
	public void setAmountFruit(BigDecimal amountFruit) {
		this.amountFruit = amountFruit;
	}
	public BigDecimal getAmountIce() {
		return amountIce;
	}
	public void setAmountIce(BigDecimal amountIce) {
		this.amountIce = amountIce;
	}
	public BigDecimal getAmountCondensedMilk() {
		return amountCondensedMilk;
	}
	public void setAmountCondensedMilk(BigDecimal amountCondensedMilk) {
		this.amountCondensedMilk = amountCondensedMilk;
	}
	public BigDecimal getAmountSugar() {
		return amountSugar;
	}
	public void setAmountSugar(BigDecimal amountSugar) {
		this.amountSugar = amountSugar;
	}
	public Ingredient getFruitIngredient() {
		return fruitIngredient;
	}
	public void setFruitIngredient(Ingredient fruitIngredient) {
		this.fruitIngredient = fruitIngredient;
	}
	
	
}
