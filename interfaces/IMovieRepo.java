package interfaces;

import java.lang.*;

import entity.*;

public interface IMovieRepo
{
	public void insertMovie(Movie m);
	public void deletMovie(String mID);
	public void updateMovie(Movie m);
	public Movie searchMovie(String name);
	public String[][] getAllMovie();
}