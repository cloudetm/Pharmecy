package sellpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import historydao.History;
import historydao.HistoryDAOImp;
import paitentdao.PaitentDAOImp;
import pilldao.PillDAOImp;
import pillinsurance.Pill_insuranceDAOImp;
import pillinsurance.pillinsurance;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Sellpage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	int i=3;
	private JLabel lblAmount;
	private JTextField textField_2;
	private JButton btnAddPill;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sellpage frame = new Sellpage();
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
	public Sellpage() {
		setForeground(new Color(0, 255, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 360);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.green);
		contentPane.setLayout(null);
		
		JLabel lblPaitentId = new JLabel("Paitent ID:");
		lblPaitentId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPaitentId.setBounds(24, 38, 100, 25);
		contentPane.add(lblPaitentId);
		
		JLabel lblPillId = new JLabel("Pill ID:");
		lblPillId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPillId.setBounds(24, 106, 100, 25);
		contentPane.add(lblPillId);
		
		textField = new JTextField();
		textField.setBounds(141, 43, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 111, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSell = new JButton("Sell");
		btnSell.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSell.setBounds(24, 246, 94, 38);
		contentPane.add(btnSell);
		
		lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAmount.setBounds(24, 166, 94, 25);
		contentPane.add(lblAmount);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 171, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		
		JButton btnAddPaitent = new JButton("Add Paitent");
		btnAddPaitent.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddPaitent.setBounds(141, 246, 159, 38);
		
		
		ActionListener acSell=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PaitentDAOImp paitent=new PaitentDAOImp();
				PillDAOImp pill=new PillDAOImp();
				Pill_insuranceDAOImp pp=new Pill_insuranceDAOImp();
				if(paitent.exists(Integer.parseInt(textField.getText()))){
					
					
					if(pill.exists(Integer.parseInt(textField_1.getText()))){
						if(pill.checkAmount(Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()))){
							HistoryDAOImp history=new HistoryDAOImp();
							history.add(new History(
									
									Integer.parseInt(textField_1.getText()),
									Integer.parseInt(textField.getText()), 
									Integer.parseInt(textField_2.getText()),
									Integer.parseInt(textField_2.getText())*pp.getdiscount(Integer.parseInt(textField_1.getText()),paitent.getInsurance(Integer.parseInt(textField.getText()))),
									paitent.getInsurance(Integer.parseInt(textField.getText()))));
							
							JOptionPane.showMessageDialog(null, "items were sold");
									pill.decreaseAmount(Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()));
						}else{
							JOptionPane.showMessageDialog(null, "not enough pills in Storage");
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "pill does not exists !");
						
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Paitent does not exists ! pleade add one");
					contentPane.add(btnAddPaitent);
				}
				
				
			}
		};
		
		btnSell.addActionListener(acSell);
		ActionListener acAddpaitent=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Addpaitentpage p=new Addpaitentpage();
				p.setVisible(true);
				p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		};
		btnAddPaitent.addActionListener(acAddpaitent);
	}
}
