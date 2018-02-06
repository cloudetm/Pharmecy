package pilldao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import paitentdao.Paitent;


public class PillDAOImp implements PillDAO {
	final String DB_URL = "jdbc:mysql://localhost/pharmecy";
	final String USER = "root";
	final String PASS = "";
	Connection conn = null;
	Statement stmt = null;
	
	private DefaultTableModel model = new DefaultTableModel(new String[] {"id","name","cost","amount","insurance_id"}, 0);

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	@Override
	public void add(Pill p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			

			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO pills(id,name,cost,amount,insurance_id)"+ 
			"VALUES('"+p.getId()+"','"+p.getName()+"','"+p.getCost()+"','"+p.getAmount()+"','"+p.getInsurance_id()+"')";
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			

			stmt = conn.createStatement();
			String sql;
			sql = "DELETE FROM pills WHERE ID="+id;
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Pill load(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM pills where id="+id;
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			// Retrieve by column name
			int i = rs.getInt("id");
			String name = rs.getString("name");
			int cost = rs.getInt("cost");
			int amount = rs.getInt("amount");
			int insurance_id = rs.getInt("insurance_id");
			Pill t = new Pill(i,name,cost,amount,insurance_id);
			
			return t;
			

		}
		// STEP 6: Clean-up environment
		rs.close();
		stmt.close();
		conn.close();
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void loads(JTable jb) {
		ArrayList<Pill> pills=new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM pills";
		ResultSet rs = stmt.executeQuery(sql);
		model.addRow(new Object[] {"id","name","cost","amount","insurance_id"});

		while (rs.next()) {
			// Retrieve by column name
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int cost = rs.getInt("cost");
			int amount = rs.getInt("amount");
			int insurance_id = rs.getInt("insurance_id");
			Pill t = new Pill(id,name,cost,amount,insurance_id);
			
			pills.add(t);
			
			model.addRow(new Object[] {id,name,cost,amount,insurance_id});


		}
		jb.setModel(model);

		// STEP 6: Clean-up environment
		rs.close();
		stmt.close();
		conn.close();
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void edit(int id, int cost) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			

			stmt = conn.createStatement();
			String sql;
			sql = "UPDATE pills SET cost="+cost+" where ID="+id;
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean exists(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM pills ";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			// Retrieve by column name
			if(rs.getInt("id")==id){
				return true;
				
			}

		}
		// STEP 6: Clean-up environment
		rs.close();
		stmt.close();
		conn.close();
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public int getCost(int id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM pills where id="+id;
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int a=rs.getInt("cost");
			return a;
			

		}
		// STEP 6: Clean-up environment
		rs.close();
		stmt.close();
		conn.close();
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public boolean checkAmount(int id,int amount){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM pills where id="+id;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
			if(rs.getInt("amount")>=amount)
				return true;
					
		// STEP 6: Clean-up environment
		rs.close();
		stmt.close();
		conn.close();
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	@Override
	public void decreaseAmount(int id,int amount){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM pills where id="+id;
		ResultSet rs = stmt.executeQuery(sql);
		int a = 0;
		while(rs.next())
			a=rs.getInt("amount");
		String s;
		
		s = "UPDATE pills SET amount="+(a-amount)+" where ID="+id;
		stmt.executeUpdate(s);
		
			
					
		// STEP 6: Clean-up environment
		rs.close();
		stmt.close();
		conn.close();
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void edit(Pill p,int id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			

			stmt = conn.createStatement();
			String sql;
			sql = "UPDATE pill SET name='"+p.getName()+"',insurance_id='"
			+p.getInsurance_id()+"',cost='"+p.getCost()
			+"',amount='"+p.getAmount()+" where ID="+id;
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
