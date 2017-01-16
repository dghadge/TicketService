package com.sbc.dao;

import com.sbc.model.SeatHold;

public interface SeatHoldDAO {
	
	public int numSeatsAvailable();
    
    SeatHold findAndHoldSeats(int numSeats, String customerEmail);
    
    int reserveSeats(int seatHoldId, String customerEmail);

}
