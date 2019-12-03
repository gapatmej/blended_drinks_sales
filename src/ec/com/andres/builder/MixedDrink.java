package ec.com.andres.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ec.com.andres.entities.Size;
import ec.com.andres.enums.FlavorEnum;

public class MixedDrink extends DrinkBuilder {

	private Size size;
	private List<FlavorEnum> listFlavor = new ArrayList<>();
	
	public MixedDrink(List<FlavorEnum> listFlavors) {
		for(FlavorEnum f : listFlavors) {
			listFlavor.add(f);
		}
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public void setName() {
		StringBuilder sb = new StringBuilder();
		sb.append("Mixed of ");
		String prefix = "";
		for(FlavorEnum f : listFlavor) {
			sb.append(prefix);
			prefix = "-";
			sb.append(f.getName());
		}
		drink.setName(sb.toString());
	}

	@Override
	public void setPercentageProfit() {
		drink.setPercentageProfit(new BigDecimal(2));
	}

	@Override
	public void setSize() {
		drink.setSize(size);
	}

	@Override
	public void setFlavor() {
		
		for(FlavorEnum f : listFlavor) {
			if (f == FlavorEnum.STRAWBERRY) {
				drink.getListFlavor().add(StrawberryDrink.createFlavor());
			} else if (f == FlavorEnum.BANANA) {
				drink.getListFlavor().add(BananaDrink.createFlavor());
			} else if (f == FlavorEnum.MANGO) {
				drink.getListFlavor().add(MangoDrink.createFlavor());
			}
		}
		
	}

}
