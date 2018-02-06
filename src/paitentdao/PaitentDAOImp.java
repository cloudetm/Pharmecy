package paitentdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import employeedao.Employee;
import pilldao.Pill;

public class PaitentDAOImp implements PaitentDAO{

	final String DB_URL = "jdbc:mysql://localhost/pharmecy";
	final String USER = "root";
	final String PASS = "";
	Connection conn = null;
	Statement stmt = null;
	 private DefaultTableModel model = new DefaultTableModel(new String[] {"id","name","insurance_id"}, 0);

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	@Override
	public void add(Paitent p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			

			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO paitent(name,insurance_id)"+ 
			"VALUES('"+p.getName()+"','"+p.getInsurance_id()+"')";
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
			sql = "DELETE FROM paitent WHERE ID="+id;
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void loads(JTable jb) {
		ArrayList<Paitent> paitents=new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM paitent";
		ResultSet rs = stmt.executeQuery(sql);
		model.addRow(new Object[] {"id","name","insurance_id"});

		while (rs.next()) {
			// Retrieve by column name
			int i = rs.getInt("id");
			String name = rs.getString("name");
			int insurance_id = rs.getInt("insurance_id");
			Paitent t = new Paitent(name,insurance_id);
			
			paitents.add(t);
			model.addRow(new Object[] {i,name,insurance_id});

			
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
	public boolean exists(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM paitent ";
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
	public int getInsurance(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM paitent";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {

			if(id==rs.getInt("id"))
				return rs.getInt("insurance_id");


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
	public void edit(Paitent p,int id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			

			stmt = conn.createStatement();
			String sql;
			sql = "UPDATE paitent SET name='"+p.getName()+"',insurance_id='"+p.getInsurance_id()+"'"+" where ID="+id;
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
