package business.model;

public abstract class TouristicSite {
	
	String id;
	String name;
	String idIsle;
	String price;
	String visitTime;
	
	public TouristicSite() {
		
	}
	
	public TouristicSite(String id, String name, String idIsle, String price, String visitTime) {
		this.id = id;
		this.name = name;
		this.idIsle = idIsle;
		this.price = price;
		this.visitTime = visitTime;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIdIsle() {
		return idIsle;
	}
	
	public void setIdIsle(String idIsle) {
		this.idIsle = idIsle;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getVisitTime() {
		return visitTime;
	}
	
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

}