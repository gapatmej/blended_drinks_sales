package ec.com.andres.enums;

public enum OptionEnum {
	INVENTORY("Check Inventory"),
	SELL_DRINK("Sell Drink"),
	REPORT_SALES("Sales Report"),;
	
	private String name;

	OptionEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
