package business.model;

public abstract class Transport {
	
	private int pricePerHour;
	private int timeOfUse;
	
	public Transport() {
		
	}
	
	public Transport(int pricePerHour, int timeOfUse) {
		this.pricePerHour = pricePerHour;
		this.timeOfUse = timeOfUse;
	}
	
	public int getPricePerHour() {
		return pricePerHour;
	}
	
	public int getTimeOfUse() {
		return timeOfUse;
	}

}