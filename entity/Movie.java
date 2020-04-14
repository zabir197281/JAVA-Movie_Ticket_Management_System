package entity;

import java.lang.*;

public class Movie
{
	private String MovieId;
	private String name;
	private String duration;
	private double price;
	private String time;
	private String date;
	private String sitfilledup;
	
	public Movie(){}
	public Movie(String MovieId, String name, String duration, double price,String time,String date,String sitfilledup)
	{
		this.MovieId = MovieId;
		this.name = name;
		this.duration = duration;
		this.price = price;
		this.time=time;
		this.date=date;
		this.sitfilledup=sitfilledup;
	}
	
	public void setMovieId(String MovieId){this.MovieId = MovieId;}
	public void setName(String name){this.name = name;}
	public void setDuration(String duration){this.duration = duration;}
	public void setPrice(double price){this.price = price;}
	public void settime(String time){this.time=time;}
	public void setdate(String date){this.date=date;}
	public void setsitfilledup(String sitfilledup){this.sitfilledup=sitfilledup;}
	
	
	public String getMovieId(){return MovieId;}
	public String getName(){return name;}
	public String getDuration(){return duration;}
	public double getPrice(){return price;}
	public String gettime(){return time;}
	public String getdate(){return date;}
	public String getsitfilledup(){return sitfilledup;}
}