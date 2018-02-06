package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import employeedao.EmployeeDAOImp;
import employeepage.Emppage;
import managerpage.Managerpage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	EmployeeDAOImp edi=new EmployeeDAOImp();
	private JTextField textField;
	private JPasswordField textField_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.blue);

		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblUsername.setBackground(new Color(0, 255, 0));
		lblUsername.setForeground(Color.RED);
		lblUsername.setBounds(34, 72, 157, 38);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 255, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblPassword.setBounds(34, 155, 157, 38);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(201, 72, 130, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setBounds(201, 155, 130, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(119, 245, 136, 38);
		contentPane.add(btnNewButton);
		
		
		ActionListener ac=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(edi.exists(textField.getText(), String.valueOf(textField_1.getPassword()))){
					if(edi.getE().isIsmanager()==1){
						Managerpage m=new Managerpage();
						m.getFrame().setVisible(true);
						setVisible(false);
					}else{
						Emppage em=new Emppage();
						setVisible(false);
					}

				}else{
					JOptionPane.showMessageDialog(null, "Username or Password is incorrect");
				}
				
			}
		};
		
		btnNewButton.addActionListener(ac);
	}
}
