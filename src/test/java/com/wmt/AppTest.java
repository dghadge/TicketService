package com.wmt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wmt.controller.TicketingController;
import com.wmt.dao.SeatHoldDAO;

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
}
