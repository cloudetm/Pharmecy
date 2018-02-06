package employeedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import paitentdao.Paitent;


public class EmployeeDAOImp implements EmployeeDAO {
	
	private Employee e;
	final String DB_URL = "jdbc:mysql://localhost/pharmecy";
	final String USER = "root";
	final String PASS = "";
	Connection conn = null;
	Statement stmt = null;
	 private DefaultTableModel model = new DefaultTableModel(new String[] {"id","name","password"}, 0);

	@Override
	public void add(Employee s) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			

			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO employee(name,password,ismanager)"+ 
			"VALUES('"+s.getName()+"','"+s.getPassword()+"','"+"0"+"')";
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
			sql = "DELETE FROM employee WHERE ID="+id;
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void edit(int id, Employee s) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			

			stmt = conn.createStatement();
			String sql;
			sql = "UPDATE employee SET name='"+s.getName()+"',password='"+s.getPassword()+"'"+" where ID="+id;
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public Employee getInfo(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM employee where id="+id;
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			// Retrieve by column name
			int i = rs.getInt("id");
			String name = rs.getString("name");
			String password = rs.getString("password");
			int ismanager=rs.getInt("ismanager");
			Employee t = new Employee(i,name,password,ismanager);
			
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
		
	
	@Override
	public boolean exists(String name, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM employee ";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			// Retrieve by column name
			if(rs.getString("name").equals(name) && rs.getString("password").equals(password)){
				int i = rs.getInt("id");
				String n = rs.getString("name");
				String p = rs.getString("password");
				int ismanager=rs.getInt("ismanager");
				 setE(new Employee(i,n,p,ismanager));
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


	public Employee getE() {
		return e;
	}


	public void setE(Employee e) {
		this.e = e;
	}
	
	@Override
	public void loads(JTable jb) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM employee";
		ResultSet rs = stmt.executeQuery(sql);
		model.addRow(new Object[] {"id","name","password"});

		while (rs.next()) {
			// Retrieve by column name
			int i = rs.getInt("id");
			String name = rs.getString("name");
			String password = rs.getString("password");
			
			if(!rs.getBoolean("ismanager"))
				model.addRow(new Object[] {i,name,password});

			
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
		
	


}