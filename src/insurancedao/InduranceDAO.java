package insurancedao;

import javax.swing.JTable;

public interface InduranceDAO {
	public void add(Insurance i);
	public void delete(int id);
	public void edit(int id,int discount);
	public Insurance getInfo(int id);
	public void loads(JTable jb);

}
