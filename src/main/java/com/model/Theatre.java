package com.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;
	@NotNull
	@Size(min=1,message="Atlest 1 character is required")
	private String tName;
	@NotNull
	@Size(min=1,message="atlest 1 value is required")
	private String timings;

	
	
	
	/*
	 * @ManyToOne()
	 * 
	 * private Place place;
	 * 
	 * @OneToMany private List<Movie> movie;
	 */
	 
	@ManyToOne
	private Movie movie;
	
	public Movie getMovie() {
		return movie;
	}


	


	public void setMovie(Movie movie) {
		this.movie = movie;
	}





	/*
	 * public Place getPlace() { return place; }
	 * 
	 * 
	 * public void setPlace(Place place) { this.place = place; }
	 * 
	 * 
	 * public List<Movie> getMovie() { return movie; }
	 * 
	 * 
	 * public void setMovie(List<Movie> movie) { this.movie = movie; }
	 * 
	 */
	public int gettId() {
		return tId;
	}
	
	
	/*
	 * public Place getPlace() { return place; }
	 * 
	 * public void setPlace(Place place) { this.place = place; }
	 * 
	 * public List<Movie> getMovie() { return movie; }
	 * 
	 * public void setMovie(List<Movie> movie) { this.movie = movie; }
	 */

	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	
	public Theatre(int tId, String tName, String timings) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.timings = timings;
		
	}
	public Theatre() {
		super();
	}
	

}
