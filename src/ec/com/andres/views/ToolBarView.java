package ec.com.andres.views;

import ec.com.andres.enums.ToolBarMenuEnum;

public class ToolBarView {


	public static String generateOptions(ToolBarMenuEnum... args) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder = new StringBuilder();
		strBuilder.append("############   OPTIONS   ##############" + "\n");
		for (ToolBarMenuEnum t : args) {
			strBuilder.append(t.getKey() + " = " + t.getName() + "\n");
		}
		strBuilder.append("#######################################" + "\n");

		return strBuilder.toString();
	}

}
