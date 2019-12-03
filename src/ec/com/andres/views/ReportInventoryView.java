package ec.com.andres.views;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import ec.com.andres.cache.DataBaseCache;
import ec.com.andres.entities.Ingredient;
import ec.com.andres.enums.ToolBarMenuEnum;
import ec.com.andres.utils.Utils;

public class ReportInventoryView extends ViewController {

	public ReportInventoryView() {
		message = null;
		getInput();
	}

	private void generateReport() {
		clearConsole();
		DataBaseCache<Ingredient> dataBaseCache = DataBaseCache.getDataBaseCache();
		List<Ingredient> listIngredientCache = dataBaseCache.getList(Ingredient.class);

		StringBuilder strBuilder = new StringBuilder();
		strBuilder = new StringBuilder();
		strBuilder.append("**********************************************" + "\n");
		strBuilder.append("**********    Inventory Report    ************" + "\n");
		strBuilder.append(ToolBarView.generateOptions(ToolBarMenuEnum.QUIT, ToolBarMenuEnum.RETURN) + "\n\n");
		strBuilder.append("______________________________________________" + "\n");
		strBuilder.append("______________________________________________" + "\n");
		strBuilder.append(Utils.padRightZeros("Nº", 5));
		strBuilder.append(Utils.padRightZeros("Name", 20));
		strBuilder.append(Utils.padRightZeros("Stock", 8)+ "\n");
		strBuilder.append("______________________________________________" + "\n");
		int i = 1;
		for (Ingredient ingredient : listIngredientCache) {
			strBuilder.append(Utils.padRightZeros(i + ". " , 5));
			strBuilder.append(Utils.padRightZeros(ingredient.getName(), 20));
			strBuilder.append(Utils.padRightZeros(ingredient.getStock().setScale(2, BigDecimal.ROUND_HALF_EVEN).toString(), 8)+ "\n");
			i++;
		}
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
