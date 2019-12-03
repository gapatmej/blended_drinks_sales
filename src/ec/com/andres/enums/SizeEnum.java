package ec.com.andres.enums;

public enum SizeEnum {
	SMALL ("Small 300 ml"),
	MEDIUM ("Medium 400 ml"),
	LARGE ("Large 500 ml"),;
	
	private String name;

	SizeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
