package business.model;

public class Hotel {
	
	private String id;
	private String idIsle;
	private String standing;
	private int price;
	
	public Hotel() {
		
	}
	
	public Hotel(String id, String idIsle, String standing, int price) {
		this.id = id;
		this.idIsle = idIsle;
		this.standing = standing;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
