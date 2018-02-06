package pillinsurance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import paitentdao.Paitent;
import pilldao.PillDAOImp;

public class Pill_insuranceDAOImp implements Pill_insuranceDAO{

	final String DB_URL = "jdbc:mysql://localhost/pharmecy";
	final String USER = "root";
	final String PASS = "";
	Connection conn = null;
	Statement stmt = null;
	 DefaultTableModel model = new DefaultTableModel(new String[] {"id","Pill_id","insurance_id","discount"}, 0);

	@Override
	public void getInsuranceid(JTable jb) {
		ArrayList<Paitent> paitents=new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM pillinsurance";
		ResultSet rs = stmt.executeQuery(sql);
		model.addRow(new Object[] {"id","Pill_id","insurance_id","discount"});

		while (rs.next()) {
			// Retrieve by column name
			int i = rs.getInt("id");
			int Pill_id = rs.getInt("Pill_id");
			int discount = rs.getInt("discount");
			int insurance_id = rs.getInt("Insurance_id");	
			model.addRow(new Object[] {i,Pill_id,insurance_id,discount});


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
	public int getdiscount(int pill_id, int insurance_id) {
		PillDAOImp p=new PillDAOImp();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM pillinsurance";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int a=rs.getInt("pill_id");
			int b=rs.getInt("insurance_id");
			int c=rs.getInt("discount");
			
			if(pill_id==a &&  insurance_id==b){
				System.out.println(c);
				return (100-c)*p.getCost(pill_id)/100;
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
		return 0;
		
	}

	@Override
	public void add(pillinsurance p) {
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		

		stmt = conn.createStatement();
		String sql;
		sql = "INSERT INTO pillinsurance(id,Pill_id,insurance_id,discount)"+ 
		"VALUES('"+p.getId()+"','"+p.getPill_id()+"','"+p.getInsurance_id()+
		"','"+p.getDiscount()+"')";
		stmt.executeUpdate(sql);
		
		
		stmt.close();
		conn.close();

	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	
	@Override
	public void delete(int id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			

			stmt = conn.createStatement();
			String sql;
			sql = "DELETE FROM pillinsurance WHERE ID="+id;
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
