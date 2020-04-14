package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repository.*;
import entity.*;


public class RegistrationFrame extends JFrame implements ActionListener
{
	private JLabel customeridLabel,passLabel,confermpassLabel,nameLabel,phoneLabel;
	private JTextField customeridTF,nameTF,phoneTF;
	private JButton logoutBtn,submitBtn, backBtn;
	private JPasswordField passPF,confermpassPF;
	private JPanel panel;
	private LoginFrame lf;
	private UserRepo ur;
	private CustomerRepo cr;
	
	public RegistrationFrame(LoginFrame lf)
	{
		super("Register Now !!!");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		ur = new UserRepo();
		cr = new CustomerRepo();
		
		this.lf = lf;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(200,100,120,30);
		panel.add(nameLabel);
		
		customeridLabel = new JLabel("CustomerID:");
		customeridLabel.setBounds(200,140,120,30);
		panel.add(customeridLabel);
		
		passLabel = new JLabel("Password:");
		passLabel.setBounds(200,180,120,30);
		panel.add(passLabel);
		
		
		phoneLabel = new JLabel("Phone Number:");
    	phoneLabel.setBounds(200,220,120,30);
		panel.add(phoneLabel);
		
		
		
		
		
		
		
		nameTF = new JTextField(" ");
		nameTF.setBounds(350,100,100,30);
		panel.add(nameTF);
		
		
		customeridTF = new JTextField("");
		customeridTF.setBounds(350,140,100,30);
		panel.add(customeridTF);
		
		passPF = new JPasswordField("");
		passPF.setBounds(350,180,100,30);
		panel.add(passPF);
		
		
		phoneTF = new JTextField(" ");
		phoneTF.setBounds(350,220,100,30);
		panel.add(phoneTF);
		
		
		
		
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(250,350,80,30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(370,350,80,30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		this.add(panel);
	}
	
	  
	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		if(command.equals(submitBtn.getText()))
		{
			
			User u = new User();
			u.setUserId(customeridTF.getText());
			u.setPassword(passPF.getText());
			u.setStatus(2);
			
			Customer c =new Customer();
			
			c.setName(nameTF.getText());
			c.setCustomerId(customeridTF.getText() );
			c.setPhoneNumber(phoneTF.getText());
			
			
			ur.insertUser(u);
			cr.insertCustomer(c);
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+customeridTF.getText()+"and Password: "+passPF.getText());
			
			customeridTF.setText("");
			nameTF.setText("");
			phoneTF.setText("");
			
			passPF.setText("");
			
			
			
		}
		else if(command.equals(backBtn.getText()))
		{
			this.setVisible(false);
			lf.setVisible(true);
		}
		else{}
	}
}