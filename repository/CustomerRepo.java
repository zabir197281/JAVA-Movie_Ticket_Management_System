package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class CustomerRepo implements ICustomerRepo

{
	DatabaseConnection dbc;
	
	public CustomerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertCustomer(Customer c)
	{
		String query = "INSERT INTO Customer VALUES ('"+c.getName()+"','"+c.getCustomerId()+"','"+c.getPhoneNumber()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	
	
	
}