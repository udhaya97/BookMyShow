package com.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Seats {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int sId;
	private String thName;
	private String timings;
	private String seats;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getThName() {
		return thName;
	}
	public void setThName(String thName) {
		this.thName = thName;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	
	public Seats(int sId, String thName, String timings, String seats) {
		super();
		this.sId = sId;
		this.thName = thName;
		this.timings = timings;
		this.seats = seats;
	}
	public Seats() {
		super();
	}
	
	

}
