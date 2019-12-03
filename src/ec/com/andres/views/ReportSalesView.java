package ec.com.andres.views;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import ec.com.andres.cache.DataBaseCache;
import ec.com.andres.entities.Drink;
import ec.com.andres.enums.ToolBarMenuEnum;
import ec.com.andres.utils.Utils;

public class ReportSalesView extends ViewController {

	public ReportSalesView() {
		message = null;
		getInput();
	}

	private void generateReport() {
		clearConsole();
		DataBaseCache<Drink> dataBaseCache = DataBaseCache.getDataBaseCache();
		List<Drink> listDrink = dataBaseCache.getList(Drink.class);

		StringBuilder strBuilder = new StringBuilder();
		strBuilder = new StringBuilder();
		strBuilder.append("**********************************************" + "\n");
		strBuilder.append("**********    Sales Report    ************" + "\n");
		strBuilder.append(ToolBarView.generateOptions(ToolBarMenuEnum.QUIT, ToolBarMenuEnum.RETURN) + "\n\n");
		strBuilder.append("__________________________________________________________________________________" + "\n");
		strBuilder.append("__________________________________________________________________________________" + "\n");
		strBuilder.append(Utils.padRightZeros("Nº", 5));
		strBuilder.append(Utils.padRightZeros("Name", 40));
		strBuilder.append(Utils.padRightZeros("Size", 20));
		strBuilder.append(Utils.padRightZeros("Cost", 10));
		strBuilder.append(Utils.padRightZeros("Price", 10)+"\n");
		strBuilder.append("__________________________________________________________________________________" + "\n");
		int i = 1;
		BigDecimal totalCost = BigDecimal.ZERO;
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (Drink drink : listDrink) {
			totalCost = totalCost.add(drink.getCost());
			totalPrice = totalPrice.add(drink.getPrice());
			strBuilder.append(Utils.padRightZeros(i + ". " , 5));
			strBuilder.append(Utils.padRightZeros(drink.getName(), 40));
			strBuilder.append(Utils.padRightZeros(drink.getSize().getSizeEnum().getName(), 20));
			strBuilder.append(Utils.padRightZeros(drink.getCost().setScale(2, BigDecimal.ROUND_HALF_EVEN).toString(), 10));
			strBuilder.append(Utils.padRightZeros(drink.getPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN).toString(), 10)+ "\n");
			i++;
		}
		
		strBuilder.append("__________________________________________________________________________________" + "\n");
		strBuilder.append(Utils.padRightZeros("TOTALS", 65));
		strBuilder.append(Utils.padRightZeros(totalCost.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString(), 10));
		strBuilder.append(Utils.padRightZeros(totalPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString(), 10)+"\n");
		strBuilder.append("__________________________________________________________________________________" + "\n");
		if (message != null)
			strBuilder.append("Message :" + message);
		System.out.println(strBuilder.toString());
	}

	public void getInput() {
		while (true) {
			generateReport();
			Scanner myObj = new Scanner(System.in);
			System.out.println("Input an option");
			String opcion = myObj.nextLine();

			switch (opcion) {
			case "R":
				return;
			case "Q":
				System.exit(0);
			default:
				message = "Option not registred!";
			}

		}

	}
}
