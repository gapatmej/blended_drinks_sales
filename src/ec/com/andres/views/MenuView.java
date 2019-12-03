package ec.com.andres.views;

import java.util.Scanner;

import ec.com.andres.builder.BananaDrink;
import ec.com.andres.builder.MangoDrink;
import ec.com.andres.builder.MixedDrink;
import ec.com.andres.builder.SellerBuilder;
import ec.com.andres.builder.StrawberryDrink;
import ec.com.andres.entities.Drink;
import ec.com.andres.enums.FlavorEnum;
import ec.com.andres.enums.OptionEnum;
import ec.com.andres.enums.ToolBarMenuEnum;

public class MenuView extends ViewController {

	public MenuView() {
		message=null;
		getInput();
	}

	private void generateOptions() {
		clearConsole();
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("**********************************************" + "\n");
		strBuilder.append("***** Welcome to Blended Drinks Sales *******" + "\n\n");
		strBuilder.append(ToolBarView.generateOptions(ToolBarMenuEnum.QUIT) + "\n\n");
		for (OptionEnum o : OptionEnum.values()) {
			strBuilder.append(o.ordinal() + ". " + o.getName() + "\n");
		}
		if (message != null)
			strBuilder.append("Message :" + message);

		strBuilder.append(showNotifications());
		System.out.println(strBuilder.toString());
	}

	public void getInput() {
		while (true) {
			generateOptions();
			Scanner scan = new Scanner(System.in);
			System.out.println("Input an option");
			String index = scan.nextLine();
			OptionEnum optionSelected = null;
			SellerBuilder sb = new SellerBuilder();
			sb.addObserver(notification);
			try {
				optionSelected = OptionEnum.values()[Integer.valueOf(index)];

				switch (optionSelected) {
				case INVENTORY:
					new ReportInventoryView();
					break;
				case SELL_DRINK:
					SizeView sizeView = new SizeView();

					if (sizeView.getFlavorView().getFlavorSelected() == FlavorEnum.STRAWBERRY) {
						StrawberryDrink drink = new StrawberryDrink();
						drink.setSize(sizeView.getSize());
						sb.setDrinkBuilder(drink);
					} else if (sizeView.getFlavorView().getFlavorSelected() == FlavorEnum.BANANA) {
						BananaDrink drink = new BananaDrink();
						drink.setSize(sizeView.getSize());
						sb.setDrinkBuilder(drink);
					} else if (sizeView.getFlavorView().getFlavorSelected() == FlavorEnum.MANGO) {
						MangoDrink drink = new MangoDrink();
						drink.setSize(sizeView.getSize());
						sb.setDrinkBuilder(drink);
					} else if (sizeView.getFlavorView().getFlavorSelected() == FlavorEnum.MIXDED) {
						MixedDrink drink = new MixedDrink(sizeView.getFlavorView().getListFlavorMixed());
						drink.setSize(sizeView.getSize());
						sb.setDrinkBuilder(drink);
					} 

					sb.doDrink();
					Drink d = sb.getDrink();
					d.save();
					sb.notifyObservers();
					break;
				case REPORT_SALES:
					new ReportSalesView();
					break;
				default:

				}
			} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
				message = "Option not registred!";
			} catch (Exception ex) {
				message = ex.getMessage();
			} finally {
				if ("Q".equals(index)) {
					System.exit(0);
				}
			}
		}
	}

}
