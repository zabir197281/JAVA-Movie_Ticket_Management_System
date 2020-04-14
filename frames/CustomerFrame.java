package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CustomerFrame extends JFrame implements ActionListener
{
	private JLabel movieIdLabel, movieNameLabel, movieDurationLabel, moviePriceLabel,timeLabel,dateLabel,sitLabel,numOftTcketLabel,moneyLabel,backmoneyLabel;
	private JTextField movieIdTF, movieNameTF, movieDurationTF, moviePriceTF,timeTF,dateTF,sitTF,numOftTcketTF,moneyTF,backmoneyTF;
	private JButton  logoutBtn,loadBtn,  updateBtn,  refreshBtn, getAllBtn, backBtn,paymentBtn;
	private JPanel panel;
	private JTable movieTable;
	private JScrollPane movieTableSP;
	private User user;

	
	
	private MovieRepo mr;
	private UserRepo ur;
	
	
	
	public CustomerFrame(User user)
	{
		super("CoustomerFrame");
		this.setSize(1200,650);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		mr = new MovieRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "","","",""}};
		
		String head[] = {"MOvieId", "MovieName", "Duration", "Time","Date","Sit_FilledUp","Price"};
		
		movieTable = new JTable(data,head);
	    movieTableSP = new JScrollPane(movieTable);
		movieTableSP.setBounds(350, 100, 800, 200);
		movieTable.setEnabled(false);
		panel.add(movieTableSP);
		
		movieIdLabel = new JLabel("ID :");
		movieIdLabel.setBounds(100,100,100,30);
		panel.add(movieIdLabel);
		
		movieIdTF = new JTextField();
		movieIdTF.setBounds(220,100,100,30);
		panel.add(movieIdTF);
		
		movieNameLabel = new JLabel("Movie Name :");
		movieNameLabel.setBounds(100,150,100,30);
		panel.add(movieNameLabel);
		
		movieNameTF = new JTextField();
		movieNameTF.setBounds(220,150,100,30);
		panel.add(movieNameTF);
		
		movieDurationLabel = new JLabel("Duration: ");
		movieDurationLabel.setBounds(100,200,100,30);
		panel.add(movieDurationLabel);
		
		movieDurationTF = new JTextField();
		movieDurationTF.setBounds(220,200,100,30);
		panel.add(movieDurationTF);
		
		
		moviePriceLabel = new JLabel("Price: ");
		moviePriceLabel.setBounds(100,250,100,30);
		panel.add(moviePriceLabel);
		
		moviePriceTF = new JTextField("");
		moviePriceTF.setBounds(220,250,100,30);
		panel.add(moviePriceTF);
		
		timeLabel = new JLabel ("Time:  ");
		timeLabel.setBounds(100,300,100,30);
		panel.add(timeLabel);
		
		timeTF = new JTextField("");
		timeTF.setBounds(220,300,100,30);
		panel.add(timeTF);
		
		dateLabel = new JLabel("Date: ");
		dateLabel.setBounds(100,350,100,30);
		panel.add(dateLabel);
		
		dateTF = new JTextField("");
		dateTF.setBounds(220,350,100,30);
		panel.add(dateTF);
		
		sitLabel = new JLabel("Sit FilledUp: ");
		sitLabel.setBounds(100,400,100,30);
		panel.add(sitLabel);
		
		sitTF = new JTextField("");
		sitTF.setBounds(220,400,100,30);
		panel.add(sitTF);
		
		
		
		
		
		loadBtn = new JButton("Search Moives");
		loadBtn.setBounds(100,460,130,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		getAllBtn = new JButton("See All Moives");
		getAllBtn.setBounds(250,460,130,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(400,460,120,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(550, 460,120, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		numOftTcketLabel = new JLabel("Number Of Tickets:");
		numOftTcketLabel.setBounds(800, 350, 150, 30);
		panel.add(numOftTcketLabel);
		
		numOftTcketTF = new JTextField("");
		numOftTcketTF.setBounds(970, 350, 80, 30);
		numOftTcketTF.setEnabled(false);
		panel.add(numOftTcketTF);
		
		moneyLabel = new JLabel("Pay Money:");
		moneyLabel.setBounds(800, 400, 150, 30);
		panel.add(moneyLabel);
		
		moneyTF = new JTextField("");
		moneyTF.setBounds(970, 400, 80, 30);
		moneyTF.setEnabled(false);
		panel.add(moneyTF);
		
		backmoneyLabel = new JLabel("Returned Money:");
		backmoneyLabel.setBounds(800, 450, 150, 30);
		panel.add(backmoneyLabel);
		
		
		backmoneyTF = new JTextField("");
		backmoneyTF.setBounds(970, 450, 80, 30);
		backmoneyTF.setEnabled(false);
		panel.add(backmoneyTF);
		
		paymentBtn = new JButton("Payment");
		paymentBtn.setBounds(930,500,120,30);
		paymentBtn.addActionListener(this);
		panel.add(paymentBtn);
		
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		
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
		
		if(command.equals(loadBtn.getText()))
		{
			if(!movieIdTF.getText().equals("") || !movieIdTF.getText().equals(null))
			{
				Movie m = mr.searchMovie(movieIdTF.getText());
				if(m!= null)
				{
					movieNameTF.setText(m.getName());
					movieIdTF.setText(m.getMovieId());
					movieDurationTF.setText(m.getDuration());
					
					timeTF.setText(m.gettime());
					dateTF.setText(m.getdate());
					sitTF.setText(m.getsitfilledup());
					
					moviePriceTF.setText(m.getPrice()+"");
					
					movieIdTF.setEnabled(false);
					movieNameTF.setEnabled(true);
					movieDurationTF.setEnabled(true);
					timeTF.setEnabled(true);
					dateTF.setEnabled(true);
					sitTF.setEnabled(true);
					moviePriceTF.setEnabled(true);
					
					
					backmoneyTF.setEnabled(true);
					moneyTF.setEnabled(true);
					numOftTcketTF.setEnabled(true);
					
					
					
					
					
					refreshBtn.setEnabled(true);
					
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(paymentBtn.getText()))
	    {
			
		          int p=Integer.parseInt(sitTF.getText())+Integer.parseInt(numOftTcketTF.getText());
		
		    if(p<=10)
			
	            {   
					   int n1=Integer.parseInt(numOftTcketTF.getText());
						if(n1<=2)
					{	
						double d1=Double.parseDouble(moviePriceTF.getText())*Double.parseDouble(numOftTcketTF.getText());
						double d2=Double.parseDouble(moneyTF.getText());
						
						if(d1<d2)
						{
						double d3=d2-d1;
						backmoneyTF.setText(Double.toString(d3));
						JOptionPane.showMessageDialog(this, "Paid");
						Movie m = new Movie();
						
						
						
						m.setMovieId(movieIdTF.getText());
						m.setName(movieNameTF.getText());
						m.setDuration(movieDurationTF.getText());
						m.setPrice(Double.parseDouble(moviePriceTF.getText()));
						m.settime(timeTF.getText());
						m.setdate(dateTF.getText());
						m.setsitfilledup(Integer.toString(p));
						mr.updateMovie(m);
						
						JOptionPane.showMessageDialog(this, "Ticket Confirm");
						
						movieIdTF.setText("");
						movieNameTF.setText("");
						movieDurationTF.setText("");
						moviePriceTF.setText("");
						timeTF.setText("");
						dateTF.setText("");
						sitTF.setText("");
						numOftTcketTF.setText("");
						moneyTF.setText("");
						backmoneyTF.setText("");
						refreshBtn.setEnabled(false);
						
						loadBtn.setEnabled(true);
						
						
						
						movieIdTF.setEnabled(true);
						movieNameTF.setEnabled(true);
						movieDurationTF.setEnabled(true);
						moviePriceTF.setEnabled(true);
							
						}
						else
						{
							JOptionPane.showMessageDialog(this, "Not Enough Money" );
						}
					}
				    else
					{
						  JOptionPane.showMessageDialog(this, "Sorry! Limite Reached" );
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this, "No available sits" );
					
				}	




				
			
	    } 
		else if(command.equals(refreshBtn.getText()))
		{
			movieIdTF.setText("");
			movieNameTF.setText("");
			movieDurationTF.setText("");
			moviePriceTF.setText("");
			numOftTcketTF.setText("");
			moneyTF.setText("");
			backmoneyTF.setText("");
			timeTF.setText("");
			dateTF.setText("");
			sitTF.setText("");
			
			
			
			
			movieIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			refreshBtn.setEnabled(false);
			backmoneyTF.setEnabled(false);
			moneyTF.setEnabled(false);
			numOftTcketTF.setEnabled(false);
			
			
			
		}
		
		
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = mr.getAllMovie();
			String head[] = {"MovieId", "Name", "Duration", "Time","Date","Sit_FilledUp","Price"};
			
			panel.remove(movieTableSP);
			
			movieTable = new JTable(data,head);
			movieTable.setEnabled(false);
			movieTableSP = new JScrollPane(movieTable);
			movieTableSP.setBounds(350, 100, 800, 200);
			
			panel.add(movieTableSP);
			
			panel.revalidate();
			panel.repaint();
			
			
		}
		else if(command.equals(backBtn.getText()))
		{
			
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}