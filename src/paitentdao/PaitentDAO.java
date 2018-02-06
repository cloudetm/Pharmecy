package paitentdao;

import java.util.ArrayList;

import javax.swing.JTable;

public interface PaitentDAO {
	
	public void add(Paitent p);
	public void delete(int id);
	public void loads(JTable jb);
	public boolean exists(int id);
	public int getInsurance(int id);
	public void edit(Paitent p,int id);

}
