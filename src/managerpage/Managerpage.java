package managerpage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import employeedao.Employee;
import employeedao.EmployeeDAOImp;
import historydao.HistoryDAOImp;
import insurancedao.Insurance;
import insurancedao.InsuranceDAOImp;
import login.Login;
import paitentdao.Paitent;
import paitentdao.PaitentDAOImp;
import pilldao.Pill;
import pilldao.PillDAOImp;
import pillinsurance.Pill_insuranceDAOImp;
import pillinsurance.pillinsurance;
import sellpage.Sellpage;

public class Managerpage {

	private JPanel contentPane;
	private JTable table;
	private String s = "";

	private JTextField textFieldName;
	private JTextField textField_Insurance_id;
	private JTextField textField_Cost;
	private JTextField textField_Amount;
	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Managerpage() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 698, 505);
		contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.green);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(206, 48, 450, 300);
		frame.getContentPane().add(table);
		contentPane.add(table);

		JButton btnPatient = new JButton("Patient");
		btnPatient.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnPatient.setBounds(31, 161, 141, 48);
		contentPane.add(btnPatient);
		JButton btnPill = new JButton("Pill");
		btnPill.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnPill.setBounds(31, 227, 141, 48);
		contentPane.add(btnPill);

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
		lblInsuranceid.setBounds(341, 357, 73, 14);
		contentPane.add(lblInsuranceid);

		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(431, 357, 66, 14);
		contentPane.add(lblCost);

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(504, 357, 86, 14);
		contentPane.add(lblAmount);

		JButton btnPillinsurance = new JButton("Pill_Insurance");
		btnPillinsurance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPillinsurance.setBounds(31, 22, 141, 44);
		contentPane.add(btnPillinsurance);

		JButton btnInsurance = new JButton("Insurance");
		btnInsurance.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnInsurance.setBounds(31, 90, 141, 48);
		contentPane.add(btnInsurance);

		JButton btnHistory = new JButton("History");
		btnHistory.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnHistory.setBounds(31, 356, 141, 44);
		contentPane.add(btnHistory);

		JTextField textFieldID = new JTextField();
		textFieldID.setBounds(225, 380, 33, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(232, 357, 26, 14);
		contentPane.add(lblId);

		JButton btnEmployee = new JButton("Employee");
		btnEmployee.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnEmployee.setBounds(31, 298, 141, 48);
		contentPane.add(btnEmployee);

		contentPane.add(textFieldName);
		contentPane.add(textField_Insurance_id);
		contentPane.add(textField_Cost);
		contentPane.add(textField_Amount);
		contentPane.add(btnAdd);
		contentPane.add(btnEdit);
		contentPane.add(btnDelete);
		contentPane.add(lblName);
		contentPane.add(lblInsuranceid);
		contentPane.add(lblCost);
		contentPane.add(lblAmount);
		textFieldName.setVisible(false);
		textField_Insurance_id.setVisible(false);
		textField_Cost.setVisible(false);
		textField_Amount.setVisible(false);
		textFieldID.setVisible(false);
		btnAdd.setVisible(false);
		btnEdit.setVisible(false);
		btnDelete.setVisible(false);
		lblName.setVisible(false);
		lblInsuranceid.setVisible(false);
		lblCost.setVisible(false);
		lblAmount.setVisible(false);
		lblId.setVisible(false);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(55, 411, 89, 23);
		contentPane.add(btnLogOut);

		ActionListener acpill = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				s = "pill";
				PillDAOImp p = new PillDAOImp();
				p.loads(table);
				textFieldName.setVisible(true);
				textField_Insurance_id.setVisible(true);
				textField_Cost.setVisible(true);
				textField_Amount.setVisible(true);
				textFieldID.setVisible(true);
				btnAdd.setVisible(true);
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				lblName.setVisible(true);
				lblInsuranceid.setVisible(true);
				lblInsuranceid.setText("Insurance_id");
				lblCost.setVisible(true);
				lblAmount.setVisible(true);
				lblId.setVisible(true);
				textField_Cost.setText(null);
				lblName.setText("name");
				lblCost.setText("amount");
				lblInsuranceid.setText("cost");
				lblAmount.setText("insurance_id");
			}
		};
		btnPill.addActionListener(acpill);
		frame.setVisible(true);

		ActionListener acpaitent = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				s = "paitent";
				PaitentDAOImp p = new PaitentDAOImp();
				p.loads(table);
				textFieldName.setVisible(true);
				textField_Insurance_id.setVisible(true);
				textFieldID.setVisible(true);
				textField_Cost.setVisible(false);
				textField_Amount.setVisible(false);
				btnAdd.setVisible(true);
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				lblName.setVisible(true);
				lblInsuranceid.setVisible(true);
				lblInsuranceid.setText("Insurance_id");
				lblId.setVisible(true);
				lblCost.setVisible(false);
				lblAmount.setVisible(false);
				textField_Cost.setText(null);
				lblName.setText("name");

			}
		};
		btnPatient.addActionListener(acpaitent);

		ActionListener acEmployee = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				s = "employee";
				// TODO Auto-generated method stub
				EmployeeDAOImp em = new EmployeeDAOImp();
				em.loads(table);
				textFieldName.setVisible(true);
				textField_Insurance_id.setVisible(true);

				textField_Cost.setVisible(false);
				textField_Amount.setVisible(false);
				textFieldID.setVisible(true);
				btnAdd.setVisible(true);
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				lblName.setVisible(true);
				lblInsuranceid.setVisible(true);
				lblInsuranceid.setText("Password");
				lblCost.setVisible(false);
				lblId.setVisible(true);
				lblAmount.setVisible(false);
				textField_Cost.setText(null);
				lblName.setText("name");

			}
		};
		btnEmployee.addActionListener(acEmployee);

		ActionListener acLogOut = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				frame.setVisible(false);

			}
		};
		btnLogOut.addActionListener(acLogOut);

		ActionListener acHistory = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InsuranceDAOImp id = new InsuranceDAOImp();
				PillDAOImp pp = new PillDAOImp();
				HistoryDAOImp h = new HistoryDAOImp();
				h.show(table);
				textFieldName.setVisible(false);
				textField_Insurance_id.setVisible(false);
				textField_Cost.setVisible(true);
				textField_Amount.setVisible(false);
				textFieldID.setVisible(false);
				btnAdd.setVisible(false);
				btnEdit.setVisible(false);
				btnDelete.setVisible(false);
				lblName.setVisible(false);
				lblInsuranceid.setVisible(false);
				lblCost.setVisible(true);
				lblAmount.setVisible(false);
				lblId.setVisible(false);
				int f = 0;
				int i = 0;
				for (int j = 1; j < table.getRowCount(); j++) {
					i = i + Integer.parseInt(table.getValueAt(j, 4).toString());
				}
				for (int j = 1; j < table.getRowCount(); j++) {
					System.out.println(pp.getCost(Integer.parseInt(table.getValueAt(j, 2).toString())));
					f = f + pp.getCost(Integer.parseInt(table.getValueAt(j, 2).toString()))
							* (Integer.parseInt(table.getValueAt(j, 3).toString()));
					id.edit(Integer.parseInt(table.getValueAt(j, 5).toString()), f - i);
				}
				textField_Cost.setVisible(false);

			}
		};
		btnHistory.addActionListener(acHistory);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (s.equals("paitent")) {
					textFieldID.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					textFieldName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					textField_Insurance_id.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				}
				if (s.equals("pill")) {
					textFieldID.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					textFieldName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					textField_Insurance_id.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
					textField_Amount.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
					textField_Cost.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				}
				if (s.equals("employee")) {
					textFieldID.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					textFieldName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					textField_Insurance_id.setText(table.getValueAt(table.getSelectedRow(), 2).toString());

				}
				if (s.equals("piin")) {
					textFieldID.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					textFieldName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					textField_Insurance_id.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
					textField_Cost.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				}
				if (s.equals("insurance")) {
					textFieldID.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					textFieldName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					textField_Insurance_id.setText(table.getValueAt(table.getSelectedRow(), 2).toString());

				}

			}
		});

		ActionListener acAdd = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (s.equals("paitent")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}

					PaitentDAOImp p = new PaitentDAOImp();
					p.add(new Paitent(textFieldName.getText(), Integer.parseInt(textField_Insurance_id.getText())));
					p.loads(table);

					JOptionPane.showMessageDialog(null, "Paitent Succefully Added");
				}
				if (s.equals("pill")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}
					PillDAOImp p = new PillDAOImp();
					p.add(new Pill(Integer.parseInt(textFieldID.getText()), textFieldName.getText(),
							Integer.parseInt(textField_Cost.getText()), Integer.parseInt(textField_Amount.getText()),
							Integer.parseInt(textField_Insurance_id.getText())));
					JOptionPane.showMessageDialog(null, "Pill Successfully Added");
					p.loads(table);

				}
				if (s.equals("employee")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}
					EmployeeDAOImp em = new EmployeeDAOImp();
					em.add(new Employee(Integer.parseInt(textFieldID.getText()), textFieldName.getText(),
							textField_Insurance_id.getText(), 0));

					JOptionPane.showMessageDialog(null, "Employee Successfully Added");
					em.loads(table);

				}
				if (s.equals("piin")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}
					Pill_insuranceDAOImp pi = new Pill_insuranceDAOImp();
					pi.add(new pillinsurance(Integer.parseInt(textFieldID.getText()),
							Integer.parseInt(textFieldName.getText()),
							Integer.parseInt(textField_Insurance_id.getText()),
							Integer.parseInt(textField_Cost.getText())));
					pi.getInsuranceid(table);
					JOptionPane.showMessageDialog(null, "Pill_Insurance Successfully Added");

				}
				if (s.equals("insurance")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}
					InsuranceDAOImp id = new InsuranceDAOImp();
					id.add(new Insurance(Integer.parseInt(textFieldID.getText()), textFieldName.getText(),
							Integer.parseInt(textField_Insurance_id.getText())));
				}

			}
		};
		btnAdd.addActionListener(acAdd);

		ActionListener acDelete = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (s.equals("paitent")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}

					PaitentDAOImp p = new PaitentDAOImp();
					p.delete(Integer.parseInt(textFieldID.getText()));
					((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());

				}
				if (s.equals("pill")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}
					PillDAOImp p = new PillDAOImp();
					p.delete(Integer.parseInt(textFieldID.getText()));
					((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());

				}
				if (s.equals("employee")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}
					EmployeeDAOImp em = new EmployeeDAOImp();
					em.delete(Integer.parseInt(textFieldID.getText()));
					JOptionPane.showMessageDialog(null, "Employee Successfully Deleted");
					em.loads(table);

				}
				if (s.equals("piin")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}
					Pill_insuranceDAOImp pi = new Pill_insuranceDAOImp();
					pi.delete(Integer.parseInt(textFieldID.getText()));
					pi.getInsuranceid(table);
					JOptionPane.showMessageDialog(null, "Pill_insurance successfully Removed");

				}
				if (s.equals("insurance")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}
					InsuranceDAOImp id = new InsuranceDAOImp();
					id.delete(Integer.parseInt(textFieldID.getText()));
					JOptionPane.showMessageDialog(null, "insurance successfully Removed");
					id.loads(table);

				}

			}
		};
		btnDelete.addActionListener(acDelete);

		ActionListener acEdit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (s.equals("paitent")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}

					PaitentDAOImp p = new PaitentDAOImp();
					p.edit(new Paitent(textFieldName.getText(), Integer.parseInt(textField_Insurance_id.getText())),
							Integer.parseInt(textFieldID.getText()));
					p.loads(table);
					JOptionPane.showMessageDialog(null, "Paitent Successfully Edited");

				}
				if (s.equals("pill")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}
					PillDAOImp p = new PillDAOImp();
					p.edit(new Pill(Integer.parseInt(textFieldID.getText()), textFieldName.getText(),
							Integer.parseInt(textField_Cost.getText()), Integer.parseInt(textField_Amount.getText()),
							Integer.parseInt(textField_Insurance_id.getText())),
							Integer.parseInt(textFieldID.getText()));
					p.loads(table);
					JOptionPane.showMessageDialog(null, "Pill Successfully Edited");

				}
				if (s.equals("employee")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}
					EmployeeDAOImp em = new EmployeeDAOImp();
					em.edit(Integer.parseInt(textFieldID.getText()),
							new Employee(Integer.parseInt(textFieldID.getText()), textFieldName.getText(),
									textField_Insurance_id.getText(), 0));
					JOptionPane.showMessageDialog(null, "Employee Successfully Edited");
					em.loads(table);

				}
				if (s.equals("insurance")) {
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ID is not entered");
						return;
					}
					InsuranceDAOImp id = new InsuranceDAOImp();
					id.edit(Integer.parseInt(textFieldID.getText()),
							Integer.parseInt(textField_Insurance_id.getText()));
					JOptionPane.showMessageDialog(null, "Insurance Successfully Edited");
					id.loads(table);
				}

			}
		};
		btnEdit.addActionListener(acEdit);

		ActionListener acpiin = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				s = "piin";
				textFieldName.setVisible(true);
				textField_Insurance_id.setVisible(true);
				textField_Cost.setVisible(true);
				textField_Amount.setVisible(false);
				textFieldID.setVisible(true);
				btnAdd.setVisible(false);
				btnEdit.setVisible(false);
				btnDelete.setVisible(false);
				lblName.setVisible(true);
				lblInsuranceid.setVisible(true);
				lblCost.setVisible(true);
				lblAmount.setVisible(false);
				lblId.setVisible(true);
				Pill_insuranceDAOImp pi = new Pill_insuranceDAOImp();
				pi.getInsuranceid(table);
				lblName.setText("Pill_id");
				lblCost.setText("discount");
				btnAdd.setVisible(true);
				btnDelete.setVisible(true);
				textField_Cost.setText(null);
				lblInsuranceid.setText("insurance_id");
			}
		};
		btnPillinsurance.addActionListener(acpiin);

		ActionListener acInsurance = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldName.setVisible(true);
				textField_Insurance_id.setVisible(true);
				textField_Cost.setVisible(false);
				textField_Amount.setVisible(false);
				textFieldID.setVisible(true);
				btnAdd.setVisible(false);
				btnEdit.setVisible(false);
				btnDelete.setVisible(false);
				lblName.setVisible(true);
				lblInsuranceid.setVisible(true);
				lblCost.setVisible(false);
				lblAmount.setVisible(false);
				lblId.setVisible(true);
				btnAdd.setVisible(true);
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				lblCost.setText(null);
				s = "insurance";
				lblInsuranceid.setText("money");
				InsuranceDAOImp id = new InsuranceDAOImp();
				id.loads(table);
				lblName.setText("name");

			}
		};
		btnInsurance.addActionListener(acInsurance);
	}

	public static void main(String[] args) {
		new Managerpage();

	}

}
