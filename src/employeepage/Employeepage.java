package employeepage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Employeepage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textFieldName;
	private JTextField textField_Insurance_id;
	private JTextField textField_Cost;
	private JTextField textField_Amount;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employeepage frame = new Employeepage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Employeepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 505);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPatient = new JButton("Patient");
		btnPatient.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnPatient.setBounds(31, 161, 141, 48);
		contentPane.add(btnPatient);
		
		JButton btnNewButton = new JButton("Pill");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(31, 227, 141, 48);
		contentPane.add(btnNewButton);
		
		JButton btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSell.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSell.setBounds(31, 298, 141, 48);
		contentPane.add(btnSell);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(55, 411, 89, 23);
		contentPane.add(btnLogOut);
		
		table_1 = new JTable();
		
		table_1.setBounds(218, 39, 332, 307);
		contentPane.add(table_1);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(268, 380, 63, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textField_Insurance_id = new JTextField();
		textField_Insurance_id.setBounds(341, 380, 63, 20);
		contentPane.add(textField_Insurance_id);
		textField_Insurance_id.setColumns(10);
		
		textField_Cost = new JTextField();
		textField_Cost.setBounds(414, 380, 63, 20);
		contentPane.add(textField_Cost);
		textField_Cost.setColumns(10);
		
		textField_Amount = new JTextField();
		textField_Amount.setBounds(487, 380, 63, 20);
		contentPane.add(textField_Amount);
		textField_Amount.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(218, 411, 63, 23);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(291, 411, 63, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(364, 411, 78, 23);
		contentPane.add(btnDelete);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(285, 357, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblInsuranceid = new JLabel("Insurance_id");
		lblInsuranceid.setBounds(341, 357, 63, 14);
		contentPane.add(lblInsuranceid);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(431, 357, 46, 14);
		contentPane.add(lblCost);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(504, 357, 46, 14);
		contentPane.add(lblAmount);
		
		JButton btnHistory = new JButton("History");
		btnHistory.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnHistory.setBounds(31, 356, 141, 44);
		contentPane.add(btnHistory);
		
		textField = new JTextField();
		textField.setBounds(225, 380, 33, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(232, 357, 26, 14);
		contentPane.add(lblId);
		
		JButton btnPillinsurance = new JButton("Pill_Insurance");
		btnPillinsurance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPillinsurance.setBounds(31, 22, 141, 44);
		contentPane.add(btnPillinsurance);
		
		JButton btnInsurance = new JButton("Insurance");
		btnInsurance.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnInsurance.setBounds(31, 90, 141, 48);
		contentPane.add(btnInsurance);
		Object rowData[][] = { { "", "", ""} };
		Object columnNames[] = { "ID", "NAME", "INSURANCE_ID"};
		TableModel model = new DefaultTableModel(rowData, columnNames);
		 table = new JTable(model);
				
	}
}
