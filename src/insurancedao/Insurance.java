package insurancedao;

public class Insurance {
	private int id;
	private String name;
	private int money=0;
	public Insurance(int id, String name, int money) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int discount) {
		this.money = discount;
	}
	
	

}
