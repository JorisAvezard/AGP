package model;

public abstract class TouristicSite {
	
	String id;
	String name;
	String idIsle;
	int price;
	int visitTime;
	
	public TouristicSite() {
		
	}
	
	public TouristicSite(String id, String name, String idIsle, int price, int visitTime) {
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
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getVisitTime() {
		return visitTime;
	}
	
	public void setVisitTime(int visitTime) {
		this.visitTime = visitTime;
	}

}