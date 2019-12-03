package ec.com.andres.notifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import ec.com.andres.builder.SellerBuilder;

public class Notification implements Observer {

	private List<String> listNotficacions = new ArrayList<>();
	
	@Override
	public void update(Observable o, Object arg) {
		this.listNotficacions = ((SellerBuilder) o ).getNotificacions();
	}

	public List<String> getListNotficacions() {
		return listNotficacions;
	}

	public void setListNotficacions(List<String> listNotficacions) {
		this.listNotficacions = listNotficacions;
	}

}
