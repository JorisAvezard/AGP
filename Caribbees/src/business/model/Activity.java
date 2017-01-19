package business.model;

public class Activity extends TouristicSite {
	
	public Activity() {
		
	}
	
	public Activity(String id, String name, String idIsle, String price, String visitTime) {
		super(id, name, idIsle, price, visitTime);
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", idIsle=" + idIsle + ", price=" + price + ", visitTime="
				+ visitTime + "]";
	}
	
	

}