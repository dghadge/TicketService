package com.sbc.service;

import com.sbc.dao.SeatHoldDAO;
import com.sbc.model.SeatHold;

import org.springframework.beans.factory.annotation.Autowired;

public class TicketServiceImpl implements TicketService {

    @Autowired
	private SeatHoldDAO seatDAO;

    public TicketServiceImpl() { }

    public int numSeatsAvailable() {
    	return seatDAO.numSeatsAvailable();    	
    }
    
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
		return seatDAO.findAndHoldSeats(numSeats, customerEmail);
	}

	public int reserveSeats(int seatHoldId, String customerEmail) {
		return seatDAO.reserveSeats(seatHoldId, customerEmail);
		
	}
}
