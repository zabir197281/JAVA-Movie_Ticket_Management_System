package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class MovieRepo implements IMovieRepo
{
	DatabaseConnection dbc;
	
	public MovieRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertMovie(Movie m)
	{
		String query = "INSERT INTO Movies VALUES ('"+m.getMovieId()+"','"+m.getName()+"','"+m.getDuration()+"',"+m.getPrice()+",'"+m.gettime()+"','"+m.getdate()+"','"+m.getsitfilledup()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deletMovie(String mID)
	{
		String query = "DELETE from Movies WHERE MovieID='"+mID+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateMovie(Movie m)
	{
		String query = "UPDATE Movies SET MovieName='"+m.getName()+"',duration = '"+m.getDuration()+"',price = "+m.getPrice()+",Time='"+m.gettime()+"',DATE='"+m.getdate()+"',SIT_FILLEDUP='"+m.getsitfilledup()+"' WHERE MovieID='"+m.getMovieId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Movie searchMovie(String mID)
	{
		Movie mo = null;
		String query = "SELECT `MovieName`, `duration`, `price`,`MovieID`,`Time`,`DATE`,`SIT_FILLEDUP` FROM `Movies` WHERE `MovieID`='"+mID+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name1 = dbc.result.getString("MovieName");
				String duration = dbc.result.getString("duration");
				String MovieID= dbc.result.getString("MovieID");
				double price = dbc.result.getDouble("price");
				String time = dbc.result.getString("Time");
				String date = dbc.result.getString("DATE");
				String sit = dbc.result.getString("SIT_FILLEDUP");
				
				mo = new Movie();
				mo.setMovieId(MovieID);
				mo.setName(name1);
				mo.setDuration(duration);
				mo.setPrice(price);
				mo.settime(time);
				mo.setdate(date);
				mo.setsitfilledup(sit);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return mo;
	}
	public String[][] getAllMovie()
	{
		ArrayList<Movie> ar = new ArrayList<Movie>();
		String query = "SELECT * FROM Movies;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String MovieID = dbc.result.getString("MovieId");
				String name = dbc.result.getString("MovieName");
				String duration = dbc.result.getString("duration");
				double price = dbc.result.getDouble("price");
				String time = dbc.result.getString("Time");
				String date = dbc.result.getString("DATE");
				String sit = dbc.result.getString("SIT_FILLEDUP");
				
				Movie mi = new Movie(MovieID,name,duration,price,time,date,sit);
				ar.add(mi);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][7];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Movie)obj[i]).getMovieId();
			data[i][1] = ((Movie)obj[i]).getName();
			data[i][2] = ((Movie)obj[i]).getDuration();
			data[i][3] = ((Movie)obj[i]).gettime();
			data[i][4] = ((Movie)obj[i]).getdate();
			data[i][5] = ((Movie)obj[i]).getsitfilledup();
			data[i][6] = (((Movie)obj[i]).getPrice())+"";
			
		}
		return data;
	}
}




