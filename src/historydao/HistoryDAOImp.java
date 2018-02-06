package historydao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import paitentdao.Paitent;

public class HistoryDAOImp implements HistoryDAO {

	final String DB_URL = "jdbc:mysql://localhost/pharmecy";
	final String USER = "root";
	final String PASS = "";
	Connection conn = null;
	Statement stmt = null;
	DefaultTableModel model = new DefaultTableModel(
			new String[] { "id", "Paitent_id", "Pill_id", "Amount", "Totalcost", "insurance_id" }, 0);

	@Override
	public void add(History s) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO history(Paitent_id,Pill_id,Amount,Totalcost,insurance_id)" + "VALUES('"
					+ s.getPaitent_id() + "','" + s.getPill_id() + "','" + s.getAmount() + "','" + s.getTotalcost()
					+ "','" + s.getInsurace_id() + "')";
			stmt.executeUpdate(sql);

			stmt.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void show(JTable jb) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			String sql;
			sql = "SELECT * FROM history";
			ResultSet rs = stmt.executeQuery(sql);
			model.addRow(new Object[] { "id", "Paitent_id", "Pill_id", "Amount", "Totalcost", "insurance_id" });

			while (rs.next()) {
				// Retrieve by column name
				int i = rs.getInt("id");
				int Paitent_id = rs.getInt("Paitent_id");
				int Pill_id = rs.getInt("Pill_id");
				int Amount = rs.getInt("Amount");
				int Totalcost = rs.getInt("Totalcost");
				int insurance_id = rs.getInt("Insurance_id");

				model.addRow(new Object[] { i, Paitent_id, Pill_id, Amount, Totalcost, insurance_id });

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
