package business.model;

public class Bus extends Transport {
	
	public Bus() {
		
	}
	
	public Bus(int pricePerHour, int timeOfUse) {
		super(pricePerHour, timeOfUse);
		pricePerHour = 5;
	}
	
}
