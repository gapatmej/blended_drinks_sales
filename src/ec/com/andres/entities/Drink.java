package ec.com.andres.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Drink extends EntityCrud<Drink> {
	
	private String name;
	private BigDecimal cost;
	private BigDecimal price;
	private Size size;
	private BigDecimal percentageProfit;
	private List<Flavor> listFlavor = new ArrayList<>();
	private BigDecimal amountIce;
	private BigDecimal amountCondensedMilk;
	private BigDecimal amountSugar;

	public Drink() {
		super.setEntity(this);
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

	public void setCost() {
		BigDecimal totalCost = BigDecimal.ZERO;
		for(Flavor f : listFlavor) {
			totalCost = totalCost.add(f.getAmountFruit()
					.divide(new BigDecimal(100))
					.multiply(f.getFruitIngredient().getCost()));
			
		}
		
		this.cost = totalCost;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice() {
		this.price = this.cost.multiply(percentageProfit);
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	
	public BigDecimal getPercentageProfit() {
		return percentageProfit;
	}

	public void setPercentageProfit(BigDecimal percentageProfit) {
		this.percentageProfit = percentageProfit;
	}
	
	public List<Flavor> getListFlavor() {
		return listFlavor;
	}

	public void setListFlavor(List<Flavor> listFlavor) {
		this.listFlavor = listFlavor;
	}

	public BigDecimal getAmountIce() {
		return amountIce;
	}

	public void setAmountIce() {
		this.amountIce = size.getAmount().multiply(Flavor.Composition.ICE.getValue()).divide(new BigDecimal(100));
	}

	public BigDecimal getAmountCondensedMilk() {
		return amountCondensedMilk;
	}

	public void setAmountCondensedMilk() {
		this.amountCondensedMilk = size.getAmount().multiply(Flavor.Composition.CONDENSED_MILK.getValue()).divide(new BigDecimal(100));
	}

	public BigDecimal getAmountSugar() {
		return amountSugar;
	}

	public void setAmountSugar() {
		this.amountSugar = size.getAmount().multiply(Flavor.Composition.SUGAR.getValue()).divide(new BigDecimal(100));
	}

	public void calculateAmountFruit() throws Exception {
		for(Flavor flavor : listFlavor) {
			BigDecimal amountFruit = size.getAmount().multiply(Flavor.Composition.FRUIT.getValue()).divide(new BigDecimal(100))
			.multiply(flavor.getAmountFruitNecesary()).divide(new BigDecimal(100))
			.divide(new BigDecimal(listFlavor.size()));
			
			if (amountFruit.compareTo(flavor.getFruitIngredient().getStock()) > 0) {
				throw new Exception("Fruit "+ flavor.getFruitIngredient().getName() + " not available!");
			}
			
			flavor.setAmountFruit(amountFruit);
		}
	}
	
	public void updateInventary() {
		for(Flavor f : listFlavor) {
			Ingredient i = f.getFruitIngredient();
			i.setStock(i.getStock().subtract(f.getAmountFruit()));
		}
	}
	


}
