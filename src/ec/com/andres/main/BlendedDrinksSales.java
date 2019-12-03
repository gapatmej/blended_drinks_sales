package ec.com.andres.main;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import ec.com.andres.builder.SellerBuilder;
import ec.com.andres.builder.StrawberryDrink;
import ec.com.andres.cache.DataBaseCache;
import ec.com.andres.entities.Drink;
import ec.com.andres.entities.Ingredient;
import ec.com.andres.entities.Size;
import ec.com.andres.views.MenuView;

public class BlendedDrinksSales {

	public static void main(String[] args) {

		loadDataBase();
		new MenuView();

		// createDataBase();
		// DataBaseCache<Ingredient> ingredientCache = DataBaseCache.getDataBaseCache();
		// System.out.println(ingredientCache.getList(Ingredient.class).size());

		/*
		 * Ingredient ingredient = new Ingredient(); ingredient.setId(163);
		 * ingredient.setName("dasda"); ingredient.save(); ingredient.setId(633);
		 * 
		 * DataBaseCache<Ingredient> ingredientCache2 =
		 * DataBaseCache.getDataBaseCache();
		 * System.out.println(ingredientCache2.getList(Ingredient.class).size());
		 * 
		 * Ingredient i = ingredientCache2.getList(Ingredient.class).get(0);
		 * System.out.println(i.getId());
		 */
		// ingredient.update(163);

		/*
		 * ingredient.remove(); ingredientCache2 = DataBaseCache.getDataBaseCache();
		 * System.out.println(ingredientCache2.getList(Ingredient.class).size());
		 */

		// MenuView menuView = new MenuView();
		/*
		 * Size size = new Size(); size.setName("Grande"); size.setAmount(new
		 * BigDecimal(500));
		 * 
		 * SellerBuilder se = new SellerBuilder( ); StrawberryDrink sd = new
		 * StrawberryDrink(); sd.setSize(size); se.setDrinkBuilder(sd); se.doDrink();
		 * Drink d = se.getDrink(); d.save();
		 * 
		 * List<Drink> drinkCache =
		 * DataBaseCache.getDataBaseCache().getList(Drink.class);
		 * 
		 * System.out.println(drinkCache.get(0).getName());
		 */
		// sd.set
		// menuView.getInput();

		// loadDataBase();
	}

	static void loadDataBase() {
		Gson gson = new Gson();
		try {
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			InputStream is = classLoader.getResourceAsStream("ingredients.json");
			InputStreamReader isr = new InputStreamReader(is);
			Type listType = new TypeToken<ArrayList<Ingredient>>() {
			}.getType();
			List<Ingredient> listIngredients = gson.fromJson(isr, listType);

			listIngredients.forEach(i -> i.save());

			is = classLoader.getResourceAsStream("sizes.json");
			isr = new InputStreamReader(is);
			listType = new TypeToken<ArrayList<Size>>() {
			}.getType();
			List<Size> listSize = gson.fromJson(isr, listType);
			listSize.forEach(i -> i.save());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
