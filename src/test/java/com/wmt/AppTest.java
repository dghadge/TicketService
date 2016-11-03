package com.wmt;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wmt.controller.TicketingController;
import com.wmt.dao.SeatHoldDAO;
import com.wmt.model.Seats;

public class AppTest {

	@InjectMocks
	TicketingController tc;

	@Mock
	private SeatHoldDAO seatHoldDAO;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testApp() {
		String result = tc.home();
		assertEquals(result, "Welcome to your ticketing service");
	}
	
	@Test
	public void testSeatsFind(){
		Seats seats = new Seats();
		seats.setSeatId((long) 99);
		
		when(seatHoldDAO.numSeatsAvailable()).thenReturn(11);
		
		//verify(seatHoldDAO).numSeatsAvailable();
		
		assertEquals(11, tc.getNumOfSeats());
	}
	
	
}
