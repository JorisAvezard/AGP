package business.engine;

import java.util.ArrayList;
import java.util.List;

import business.model.Hotel;

public class Travel {
	
	private int price;
	private List<Excursion> excursions = new ArrayList<Excursion>();
	private List<Hotel> hotels = new ArrayList<Hotel>();
	
	public Travel() {
		
	}
	
	public Travel(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Excursion> getExcursion() {
		return excursions;
	}
	
	public List<Hotel> getHotel() {
		return hotels;
	}
}
