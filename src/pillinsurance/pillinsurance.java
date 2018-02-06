package pillinsurance;

public class pillinsurance {
	private int id;
	private int pill_id;
	private int insurance_id;
	private int discount;
	public pillinsurance(int id, int pill_id, int insurance_id, int discount) {
		super();
		this.id = id;
		this.pill_id = pill_id;
		this.insurance_id = insurance_id;
		this.discount = discount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPill_id() {
		return pill_id;
	}
	public void setPill_id(int pill_id) {
		this.pill_id = pill_id;
	}
	public int getInsurance_id() {
		return insurance_id;
	}
	public void setInsurance_id(int insurance_id) {
		this.insurance_id = insurance_id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	

}
