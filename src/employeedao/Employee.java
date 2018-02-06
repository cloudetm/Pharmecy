package employeedao;

public class Employee {
	
	private int id;
	private String name;
	private String password;
	private int ismanager;
	public Employee(int id, String name, String password, int ismanager) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.ismanager = ismanager;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int isIsmanager() {
		return ismanager;
	}
	public void setIsmanager(int ismanager) {
		this.ismanager = ismanager;
	}

}
