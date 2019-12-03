package ec.com.andres.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ec.com.andres.enums.FlavorEnum;

public class FlavorView extends ViewController {

	private FlavorEnum flavorSelected = null;
	private FlavorView flavorView = null;
	private List<FlavorEnum> listFlavorMixed = new ArrayList<>();
	private FlavorEnum[] flavorsMixed = new FlavorEnum[0];
	
	public FlavorView() {
		iniziallize();
	}
	
	public FlavorView(FlavorView flavorView, FlavorEnum ... flavorsMixed) {
		this.flavorView = flavorView;
		this.flavorsMixed = flavorsMixed;
		iniziallize();
	}
	
	private void iniziallize() {
		message = null;
		getInput();
	}

	private void generateOptions() {
		super.clearConsole();
		StringBuilder strBuilder = new StringBuilder();
		strBuilder = new StringBuilder();
		strBuilder.append("**********************************************" + "\n");
		if (flavorView == null)
			strBuilder.append("**********   Flavor of Drink     **************" + "\n\n");
		else 
			strBuilder.append("********   Flavor of Drink Mixed   ************" + "\n\n");

		for (FlavorEnum f : FlavorEnum.values()) {
			if ( Arrays.stream(flavorsMixed).anyMatch(f::equals))
				continue;
			strBuilder.append(f.ordinal() + ". " + f.getName() + "\n");
		}
		if (message != null)
			strBuilder.append("Message :" + message);

		System.out.println(strBuilder.toString());
	}

	public void getInput() {
		while (true) {
			generateOptions();
			Scanner myObj = new Scanner(System.in);
			System.out.println("Input an option");
			String index = myObj.nextLine();
			try {
				FlavorEnum flavorInput = FlavorEnum.values()[Integer.valueOf(index)];
				validateOptionEnabled(flavorInput);
				switch (flavorInput) {
				case MIXDED:
					flavorSelected = flavorInput;
					FlavorView firstflavor = new FlavorView(this, flavorSelected );
					listFlavorMixed.add(firstflavor.getFlavorSelected());
					
					FlavorView secondflavor = new FlavorView(this, flavorSelected, firstflavor.getFlavorSelected());
					listFlavorMixed.add(secondflavor.getFlavorSelected());
					return;	
				default:
					flavorSelected = flavorInput;
					return;
				}
				
			} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
				message = "Option not registred!";
			} catch (Exception ex) {
				message = ex.getMessage();
			}finally {
				if ("R".equals(index)) {
					return;
				}else if("Q".equals(index)) {
					System.exit(0);
				}
			}

		}

	}
	
	private void validateOptionEnabled(FlavorEnum flavorInput) throws ArrayIndexOutOfBoundsException {
		if ( Arrays.stream(flavorsMixed).anyMatch(flavorInput::equals))
			throw new ArrayIndexOutOfBoundsException();
	}

	public FlavorEnum getFlavorSelected() {
		return flavorSelected;
	}

	public List<FlavorEnum> getListFlavorMixed() {
		return listFlavorMixed;
	}
}
