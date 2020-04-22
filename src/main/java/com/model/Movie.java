package com.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mId;
	@NotNull
	@Size(min=1,message="atleast 1 character is required")
	private String mName;
	@NotNull
	@Size(min=4,message="more than 4 character required")
	private String lang;
	@NotNull
	@Size(min=1,message="atleaset 1 digit is required")
	private String duration;

	
	  @ManyToOne()
	  
	  private Place place;
	  
	  @OneToMany private List<Theatre> theatre;
	 
	
	
	/* @ManyToOne private Theatre theatres; */
	  
	 
	 
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public List<Theatre> getTheatre() {
		return theatre;
	}
	public void setTheatre(List<Theatre> theatre) {
		this.theatre = theatre;
	}
	/*
	 * public Theatre getTheatres() { return theatres; } public void
	 * setTheatres(Theatre theatres) { this.theatres = theatres; }
	 */
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Movie(int mId, String mName, String lang, String duration) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.lang = lang;
		this.duration = duration;
	}
	public Movie() {
		super();
	}
	

}
