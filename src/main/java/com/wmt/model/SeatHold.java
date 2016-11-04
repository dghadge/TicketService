package com.wmt.model;

import java.util.List;

public class SeatHold {

	Long seatHoldId;

	String email;
	List<Seats> seats;

	public SeatHold() {
	}

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
