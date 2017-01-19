package business.model;

public class HistoricSite extends TouristicSite {
	
	public HistoricSite() {
		
	}
	
	public HistoricSite(String id, String name, String idIsle, String price, String visitTime) {
		super(id, name, idIsle, price, visitTime);
	}

	@Override
	public String toString() {
		return "HistoricSite [id=" + id + ", name=" + name + ", idIsle=" + idIsle + ", price=" + price + ", visitTime="
				+ visitTime + "]";
	}
	
	

}