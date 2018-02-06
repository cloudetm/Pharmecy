package employeedao;

import javax.swing.JTable;

public interface EmployeeDAO {
	
	public void add(Employee e);
	public void delete(int id);
	public void edit(int id,Employee e);
	public Employee getInfo(int id);
	public boolean exists(String name,String password);
	public void loads(JTable jb);
	

}
