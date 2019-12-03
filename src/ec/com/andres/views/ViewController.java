package ec.com.andres.views;

import ec.com.andres.notifications.Notification;

public class ViewController {

	protected Notification notification = new Notification(); 
	protected static String message = null;
	
	protected void clearConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception E) {
			System.out.println(E);
		}
	}
	
	protected String showNotifications() {
		StringBuilder strBuiNotifications = new StringBuilder();
		strBuiNotifications.append("\n");
		notification.getListNotficacions().forEach(
				n->strBuiNotifications.append(n).append("\n")
				);
		return strBuiNotifications.toString();
	}
}
