package com.wmt.model;
/*
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
*/
//@Entity
public class Seats {
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	Long seatId; 
	Integer rowNumber; 
	Integer seatNumber;
	String description;  
	Integer seatHoldId;
	Integer status;    // 0=available, 1=OnHold, 2=reserved

	public Seats(){ }

	public Seats(Long seatId, Integer rowNumber, Integer seatNumber,
			String description, Integer seatHoldId, Integer status) {
		this.seatId = seatId;
		this.rowNumber = rowNumber;
		this.seatNumber = seatNumber;
		this.description = description;
		this.seatHoldId = seatHoldId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Seats [seatId=" + seatId + ", rowNumber=" + rowNumber
				+ ", seatNumber=" + seatNumber + ", description=" + description
				+ ", seatHoldId=" + seatHoldId + ", status=" + status + "]";
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public Integer getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSeatHoldId() {
		return seatHoldId;
	}

	public void setSeatHoldId(Integer seatHoldId) {
		this.seatHoldId = seatHoldId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
