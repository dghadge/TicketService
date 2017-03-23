package com.sbc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
//import org.springframework.beans.factory.annotation.Qualifier;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sbc.common.RestApiResponse;
import com.sbc.common.RestApiResponse.Status;
import com.sbc.controller.TicketingController;
import com.sbc.dao.SeatHoldDAO;
import com.sbc.model.SeatHold;

public class TicketServiceUnitTest {

	@InjectMocks
	TicketingController tc;     //mockito is managing this object

	@Mock
//	@Qualifier("seatHoldDAOTest")
	private SeatHoldDAO seatHoldDAO;
	
	@Before
	public void init(){
		//just like spring controller's dependency injection; mockito will look for 
		//@InjectMocks and @Mock to create the objects before each unit test.
		MockitoAnnotations.initMocks(this);   
	}
	
	@Test
	public void testApp() {
		String result = tc.home();
		assertEquals(result, "Welcome to your ticketing service");
	}
	
	@Test
	public void testGetNumOfSeatsPositiveTest() {
		when(seatHoldDAO.numSeatsAvailable()).thenReturn(10);
		
		RestApiResponse rsp = tc.getNumOfSeats();
		assertEquals(rsp.getStatus(), Status.OK);
		assertEquals(rsp.getData(), 10);
	}
	
	@Test
	public void testGetNumOfSeatsNegativeTest() {
		when(seatHoldDAO.numSeatsAvailable()).thenReturn(0);
		
		RestApiResponse rsp = tc.getNumOfSeats();
		assertEquals(rsp.getStatus(), Status.ERROR);
	}
	
	@Test
	public void testFindAndHoldSeats() {
		String result = tc.home();
		SeatHold seatHold = new SeatHold();
		when(seatHoldDAO.findAndHoldSeats(1, "unitest@gmail.com")).thenReturn(seatHold);
		
		
		assertEquals(result, "Welcome to your ticketing service");
	}
	
	@Test
	public void testReserveSeats() {
		String result = tc.home();
		assertEquals(result, "Welcome to your ticketing service");
	}
}
