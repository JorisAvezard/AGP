package business.model;

public class Hotel {
	
	private String id;
	private String name;
	private String idIsle;
	private String standing;
	private int price;
	
	public Hotel() {
		
	}
	
	public Hotel(String id, String name, String idIsle, String standing, int price) {
		this.id = id;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", idIsle=" + idIsle + ", standing=" + standing + ", price="
				+ price + "]";
	}
	
	

}
