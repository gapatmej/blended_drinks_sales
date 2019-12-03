package ec.com.andres.entities;

import java.math.BigDecimal;

import ec.com.andres.enums.FlavorEnum;

public class Ingredient extends EntityCrud<Ingredient> {
	
	private FlavorEnum flavorEnum;
	private String name;
	private BigDecimal cost;
	private BigDecimal stock;

	public Ingredient() {
		super.setEntity(this);
	}
	
	public FlavorEnum getFlavorEnum() {
		return flavorEnum;
	}

	public void setFlavorEnum(FlavorEnum flavorEnum) {
		this.flavorEnum = flavorEnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getStock() {
		return stock;
	}

	public void setStock(BigDecimal stock) {
		this.stock = stock;
	}

}
