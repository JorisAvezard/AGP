package model;

public class Hotel {
	
	private String id;
	private String idIsle;
	private String standing;
	private String price;
	
	public Hotel(String id, String idIsle, String standing, String price) {
		this.id = id;
		this.idIsle = idIsle;
		this.standing = standing;
		this.price = price;
	}
	
	public Hotel() {
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getIdIsle() {
		return idIsle;
	}



	public void setIdIsle(String idIsle) {
		this.idIsle = idIsle;
	}



	public String getStanding() {
		return standing;
	}



	public void setStanding(String standing) {
		this.standing = standing;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Hotel [id=" + id + ", idIsle=" + idIsle + ", standing=" + standing + ", price=" + price + "]";
	}
	
	

}
