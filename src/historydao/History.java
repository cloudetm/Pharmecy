package historydao;

public class History {

	private int pill_id;
	private int paitent_id;
	private int amount;
	private int totalcost;
	private int insurance_id;
	public History( int pill_id, int paitent_id, int amount, int totalcost, int insurace_id) {
		super();
		this.pill_id = pill_id;
		this.paitent_id = paitent_id;
		this.amount = amount;
		this.totalcost = totalcost;
		this.insurance_id = insurace_id;
	}
	public int getPill_id() {
		return pill_id;
	}
	public void setPill_id(int pill_id) {
		this.pill_id = pill_id;
	}
	public int getPaitent_id() {
		return paitent_id;
	}
	public void setPaitent_id(int paitent_id) {
		this.paitent_id = paitent_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}
	public int getInsurace_id() {
		return insurance_id;
	}
	public void setinsurance_id(int insurace_id) {
		this.insurance_id = insurace_id;
	}
	
	
	
	
}
