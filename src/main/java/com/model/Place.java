package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Place {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;
@NotNull
@Size(min=4,message="more than 4 character is required")
	private String pName;
@NotNull
@Size(min=1,message="images can't be empty")
	private String imgs;

	
	
	/*
	 * @OneToMany private List<Theatre> theatre; public List<Theatre> getTheatre() {
	 * return theatre; } public void setTheatre(List<Theatre> theatre) {
	 * this.theatre = theatre; }
	 */
	 
	@OneToMany private List<Movie> movie;
	
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public List<Movie> getMovie() {
		return movie;
	}
	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public Place(int pId, String pName, String imgs) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.imgs = imgs;
	}
	public Place() {
		super();
	}
	}
