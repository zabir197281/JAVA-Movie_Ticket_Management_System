package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class MovieFrame extends JFrame implements ActionListener
{
	private JLabel movieIdLabel, movieNameLabel, movieDurationLabel, moviePriceLabel,timeLabel,dateLabel,sitLabel;
	private JTextField movieIdTF, movieNameTF, movieDurationTF, moviePriceTF,timeTF,dateTF,sitTF;
	private JButton logoutBtn, loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable movieTable;
	private JScrollPane movieTableSP;
	private User user;

	
	
	private MovieRepo mr;
	private UserRepo ur;
	
	
	
	public MovieFrame(User user)
	{
		super("MovieFrame");
		this.setSize(1200,600);
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
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
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
		
		
		
		
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,460,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,460,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,460,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,460,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,460,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(700,460,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 460, 80, 30);
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
					
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Movie m = new Movie();
			
			
			m.setMovieId(movieIdTF.getText());
			m.setName(movieNameTF.getText());
			m.setDuration(movieDurationTF.getText());
			m.settime(timeTF.getText());
			m.setdate(dateTF.getText());
			m.setsitfilledup(sitTF.getText());
			m.setPrice(Double.parseDouble(moviePriceTF.getText()));
			
			
			
			
			
			mr.insertMovie(m);
			
			
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+movieIdTF.getText() );
			
			movieIdTF.setText("");
			movieNameTF.setText("");
			movieDurationTF.setText("");
			moviePriceTF.setText("");
			timeTF.setText("");
			dateTF.setText("");
			sitTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			movieIdTF.setText("");
			movieNameTF.setText("");
			movieDurationTF.setText("");
			moviePriceTF.setText("");
			timeTF.setText("");
			dateTF.setText("");
			sitTF.setText("");
			
			
			movieIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Movie m = new Movie();
			
			m.setMovieId(movieIdTF.getText());
			m.setName(movieNameTF.getText());
			m.setDuration(movieDurationTF.getText());
			m.setPrice(Double.parseDouble(moviePriceTF.getText()));
			m.settime(timeTF.getText());
			m.setdate(dateTF.getText());
			m.setsitfilledup(sitTF.getText());
			mr.updateMovie(m);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			movieIdTF.setText("");
			movieNameTF.setText("");
			movieDurationTF.setText("");
			moviePriceTF.setText("");
			timeTF.setText("");
			dateTF.setText("");
			sitTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			movieIdTF.setEnabled(true);
			movieNameTF.setEnabled(true);
			movieDurationTF.setEnabled(true);
			moviePriceTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			mr.deletMovie(movieIdTF.getText());
			
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			movieIdTF.setText("");
			movieNameTF.setText("");
			movieDurationTF.setText("");
			moviePriceTF.setText("");
			timeTF.setText("");
			dateTF.setText("");
			sitTF.setText("");
			
			movieIdTF.setEnabled(true);
			movieNameTF.setEnabled(true);
			movieDurationTF.setEnabled(true);
			moviePriceTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
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
 