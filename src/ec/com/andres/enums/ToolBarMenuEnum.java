package ec.com.andres.enums;

public enum ToolBarMenuEnum {
	QUIT ('Q',"Exit from System"),
	RETURN ('R', "Return "),;
	
	private Character key;
	private String name;

	ToolBarMenuEnum(Character key, String name) {
		this.key = key;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public Character getKey() {
		return key;
	}
}
