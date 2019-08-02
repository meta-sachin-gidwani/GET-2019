package question3;

public class Bowler {
	
	private String name;
	private int noOfballs;
	
	public Bowler(String name, int noOfballs) {
		this.name = name;
		this.noOfballs = noOfballs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNoOfballs(int noOfballs) {
		this.noOfballs = noOfballs;
	}

	public int getNoOfballs() {
		return noOfballs;
	}
	
}
