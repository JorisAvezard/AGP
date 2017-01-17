package model;

public class Boat extends Transport {
	
	public Boat() {
		
	}
	
	public Boat(int pricePerHour, int timeOfUse) {
		super(pricePerHour, timeOfUse);
		pricePerHour = 10;
	}

}
