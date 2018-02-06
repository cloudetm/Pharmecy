package pillinsurance;

import javax.swing.JTable;

public interface Pill_insuranceDAO {
	public void getInsuranceid(JTable jb);
	public void add(pillinsurance p);
	public int getdiscount(int pill_id, int insurance_id);
	public void delete(int id);

}
