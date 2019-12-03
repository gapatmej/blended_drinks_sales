package ec.com.andres.builder;

import java.math.BigDecimal;

import ec.com.andres.entities.Flavor;
import ec.com.andres.entities.Ingredient;
import ec.com.andres.entities.Size;
import ec.com.andres.enums.FlavorEnum;

public class StrawberryDrink extends DrinkBuilder {
 
	private static final BigDecimal amountFruitNecesary = new BigDecimal(100);
	private Size size ;
	
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public void setName() {
		drink.setName(FlavorEnum.STRAWBERRY.getName());
	}

	@Override
	public void setPercentageProfit() {
		drink.setPercentageProfit(new BigDecimal(1.75));
	}

	@Override
	public void setSize() {
		drink.setSize(size);
	}
	
	@Override
	public void setFlavor() {
		drink.getListFlavor().add(createFlavor());
	}
	
	public static Flavor createFlavor() {
		Flavor flavor =  new Flavor();
		flavor.setAmountFruitNecesary(amountFruitNecesary);
		Ingredient fruitIngredient = new Ingredient();
		fruitIngredient = fruitIngredient.findByAtrribute("flavorEnum", FlavorEnum.STRAWBERRY.toString());
		flavor.setFruitIngredient(fruitIngredient);
		return flavor;
	}


}
