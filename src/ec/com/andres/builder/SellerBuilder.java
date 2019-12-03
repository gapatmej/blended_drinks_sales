package ec.com.andres.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import ec.com.andres.entities.Drink;
import ec.com.andres.entities.Flavor;

public class SellerBuilder extends Observable {
	private List<String> listNotifications = new ArrayList<>();
	private DrinkBuilder drinkBuilder;
	
	public void setDrinkBuilder(DrinkBuilder drinkBuilder) {
		this.drinkBuilder = drinkBuilder;
	}
	
	public Drink getDrink() {
		return drinkBuilder.getDrink();
	}
	
	public void doDrink() throws Exception{
		try {
			
			drinkBuilder.createDrink();
			drinkBuilder.setName();
			drinkBuilder.setFlavor();
			drinkBuilder.setPercentageProfit();
			drinkBuilder.setSize();
			drinkBuilder.getDrink().calculateAmountFruit();
			drinkBuilder.getDrink().setAmountIce();
			drinkBuilder.getDrink().setAmountCondensedMilk();
			drinkBuilder.getDrink().setAmountSugar();
			drinkBuilder.getDrink().setCost();
			drinkBuilder.getDrink().setPrice();
			drinkBuilder.getDrink().updateInventary();
			for(Flavor f : getDrink().getListFlavor()) {
				addNotification("Your stock for "+f.getFruitIngredient().getName()+
						" is : "+ f.getFruitIngredient().getStock());
			}

		}catch(Exception e) {
			addNotification(e.getMessage());
			throw e;
		}
		
		setChanged();
	}
	
	
	private void addNotification(String notification) {
		listNotifications.add(notification);
	}
	
	public List<String> getNotificacions(){
		return listNotifications;
	}
}
