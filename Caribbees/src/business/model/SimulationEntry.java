package business.model;

public class SimulationEntry {
	
	private String standing;
	private String budget;
	private String keyword;
	
	public SimulationEntry() {
		
	}
	
	public SimulationEntry(String standing, String budget, String keyword) {
		this.standing = standing;
		this.budget = budget;
		this.keyword = keyword;
	}

	public String getStanding() {
		return standing;
	}

	public void setStanding(String standing) {
		this.standing = standing;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
