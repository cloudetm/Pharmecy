package insurancedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InsuranceDAOImp implements InduranceDAO {
	final String DB_URL = "jdbc:mysql://localhost/pharmecy";
	final String USER = "root";
	final String PASS = "";
	Connection conn = null;
	Statement stmt = null;

	private DefaultTableModel model = new DefaultTableModel(new String[] { "id", "name", "money" }, 0);

	@Override
	public void add(Insurance i) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO insurance(id,name,money)" + "VALUES('" + i.getId() + "','" + i.getName()
					+ "','" + i.getMoney() + "')";
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
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(int id, int discount) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			String sql;
			sql = "UPDATE insurance SET money=" + discount + " where ID=" + id;
			stmt.executeUpdate(sql);

			stmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Insurance getInfo(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			String sql;
			sql = "SELECT * FROM insurance where id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// Retrieve by column name
				int i = rs.getInt("id");
				String name = rs.getString("name");
				int discount = rs.getInt("discount");
				Insurance t = new Insurance(i, name, discount);

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
	public void loads(JTable jb) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		
		String sql;
		sql = "SELECT * FROM insurance";
		ResultSet rs = stmt.executeQuery(sql);
		model.addRow(new Object[] {"id","name","money"});

		while (rs.next()) {
			// Retrieve by column name
			int i = rs.getInt("id");
			String name = rs.getString("name");
			int password = rs.getInt("money");
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
