package ec.com.andres.views;

import java.util.Scanner;

import ec.com.andres.entities.Size;
import ec.com.andres.enums.SizeEnum;
import ec.com.andres.enums.ToolBarMenuEnum;

public class SizeView extends ViewController {

	Size size = new Size();
	FlavorView flavorView ;
	
	public SizeView() {
		message=null;
		getInput();
	}
	
	private void generateOptions() {
		clearConsole();
		StringBuilder strBuilder = new StringBuilder();
		strBuilder = new StringBuilder();
		strBuilder.append("**********************************************" + "\n");
		strBuilder.append("**********   Size of Drink     **************" + "\n\n");
		strBuilder.append(ToolBarView.generateOptions(ToolBarMenuEnum.QUIT, ToolBarMenuEnum.RETURN) + "\n\n");
		for (SizeEnum s : SizeEnum.values()) {
			strBuilder.append(s.ordinal() + ". " + s.getName() + "\n");
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
				SizeEnum flavorSelected = SizeEnum.values()[Integer.valueOf(index) ];
				switch (flavorSelected) {
				case SMALL:
					size = size.findByAtrribute("sizeEnum", SizeEnum.SMALL.toString());
					flavorView = new FlavorView();
					if(flavorView.getFlavorSelected() != null)
						return;
					break;
				case MEDIUM:
					size = size.findByAtrribute("sizeEnum", SizeEnum.MEDIUM.toString());
					flavorView = new FlavorView();
					if(flavorView.getFlavorSelected() != null)
						return;
					break;
				case LARGE:
					size = size.findByAtrribute("sizeEnum", SizeEnum.LARGE.toString());
					flavorView = new FlavorView();
					if(flavorView.getFlavorSelected() != null)
						return;
					break;
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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public FlavorView getFlavorView() {
		return flavorView;
	}

	public void setFlavorView(FlavorView flavorView) {
		this.flavorView = flavorView;
	}
	
	

}
