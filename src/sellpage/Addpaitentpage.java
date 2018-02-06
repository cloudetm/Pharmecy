package sellpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paitentdao.Paitent;
import paitentdao.PaitentDAOImp;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Addpaitentpage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addpaitentpage frame = new Addpaitentpage();
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
	public Addpaitentpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 318, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(43, 49, 103, 29);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(178, 56, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblInsuranceid = new JLabel("Insurance_ID");
		lblInsuranceid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInsuranceid.setBounds(24, 111, 122, 29);
		contentPane.add(lblInsuranceid);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 118, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(43, 183, 89, 23);
		contentPane.add(btnAdd);
		
		
		ActionListener acAdd=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PaitentDAOImp p=new PaitentDAOImp();
				p.add(new Paitent(textField.getText(), Integer.parseInt(textField_1.getText())));
				JOptionPane.showMessageDialog(null, "Paitent created successfully");
				
			}
		};
		btnAdd.addActionListener(acAdd);
	}
}
