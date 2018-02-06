package employeepage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

public class test extends JFrame {

	private JPanel contentPane;
	private JTable tableAuthor;
	private JTable tableBook;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JTextField textFieldAuthor;
	private JLabel lblAuthorid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableAuthor = new JTable();
		tableAuthor.setBounds(175, 24, 227, 286);
		contentPane.add(tableAuthor);
		
		tableBook = new JTable();
		tableBook.setBounds(424, 24, 227, 286);
		contentPane.add(tableBook);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(195, 337, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(266, 337, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(356, 337, 46, 14);
		contentPane.add(lblPrice);
		
		JButton btnAddAuthor = new JButton("Add Author");
		btnAddAuthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddAuthor.setBounds(10, 99, 125, 38);
		contentPane.add(btnAddAuthor);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddBook.setBounds(10, 181, 125, 38);
		contentPane.add(btnAddBook);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(184, 370, 46, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(240, 370, 86, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(335, 370, 86, 20);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(175, 410, 57, 23);
		contentPane.add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(250, 410, 62, 23);
		contentPane.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(332, 410, 89, 23);
		contentPane.add(btnDelete);
		
		textFieldAuthor = new JTextField();
		textFieldAuthor.setBounds(436, 370, 86, 20);
		contentPane.add(textFieldAuthor);
		textFieldAuthor.setColumns(10);
		
		lblAuthorid = new JLabel("Author_Id:");
		lblAuthorid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAuthorid.setBounds(436, 339, 72, 14);
		contentPane.add(lblAuthorid);
	}
}
