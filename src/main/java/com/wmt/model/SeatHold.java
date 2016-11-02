package com.wmt.model;

import java.util.List;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
*/
//@Entity
public class SeatHold {

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	Long seatHoldId; 

	String email;
	List<Seats> seats;


	public SeatHold() { }
	
	public SeatHold(Long seatHoldId, String email, List<Seats> seats) {
		this.seatHoldId = seatHoldId;
		this.email = email;
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "SeatHold [seatHoldId=" + seatHoldId + ", email=" + email
				+ ", seats=" + seats + "]";
	}

	public Long getSeatHoldId() {
		return seatHoldId;
	}

	public void setSeatHoldId(Long seatHoldId) {
		this.seatHoldId = seatHoldId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

	public List<Seats> getSeats() {
		return seats;
	}

	public void setSeats(List<Seats> seats) {
		this.seats = seats;
	}

}
