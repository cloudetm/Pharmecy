package pilldao;

import paitentdao.Paitent;

public interface PillDAO {
	public void add(Pill p);
	public void delete(int id);
	public Pill load(int id);
	public void edit(int id,int cost);
	public boolean exists(int id);
	public int getCost(int id);
	public boolean checkAmount(int id,int amount);
	public void decreaseAmount(int id, int amount);
	public void edit(Pill p, int id);

}
