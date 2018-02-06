package paitentdao;

public class Paitent {
	private String name;
	private int insurance_id;
	public Paitent( String name, int insurance_id) {
		super();
		this.name = name;
		this.insurance_id = insurance_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInsurance_id() {
		return insurance_id;
	}
	public void setInsurance_id(int insurance_id) {
		this.insurance_id = insurance_id;
	}
	
	

}
