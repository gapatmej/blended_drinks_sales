package ec.com.andres.enums;

public enum FlavorEnum {
	STRAWBERRY ("STRAWBERRY"),
	BANANA ("BANANA"),
	MANGO ("MANGO"),
	MIXDED ("MIXDED");
	
	private String name;

	FlavorEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
