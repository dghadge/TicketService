package com.sbc.model;

public class Seats {
	Long seatId;
	Integer rowNumber;
	Integer seatNumber;
	String description;

	public Seats() {
	}

	public Seats(Long seatId, Integer rowNumber, Integer seatNumber,
			String description, Integer seatHoldId, Integer status) {
		this.seatId = seatId;
		this.rowNumber = rowNumber;
		this.seatNumber = seatNumber;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Seats [seatId=" + seatId + ", rowNumber=" + rowNumber
				+ ", seatNumber=" + seatNumber + ", description=" + description
				+ "]";
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

}
