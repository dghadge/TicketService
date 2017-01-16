package com.sbc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sbc.dao.SeatHoldDAO;
import com.sbc.model.SeatHold;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)

public class TicketServiceDBIntegrationTest {

	@Autowired
	@Qualifier("seatHoldDAOTest")
	private SeatHoldDAO seatHoldDAOTest;
		
	SeatHold seathold = new SeatHold();

	@Test
	public void testNumSeatsAvailable() {
		assertThat(seatHoldDAOTest.numSeatsAvailable(), is(greaterThanOrEqualTo(0)));
	}
	
	@Test
	public void testFindAndHoldSeats() {
		SeatHold seathold = seatHoldDAOTest.findAndHoldSeats(1, "test@sbc.com");
		assertThat(seathold.getSeats().size(), is(greaterThan(0)));
	}
	
	@Test
	public void testReserveSeats() {
		SeatHold seathold = seatHoldDAOTest.findAndHoldSeats(1, "test@sbc.com");
		assertThat(seatHoldDAOTest.reserveSeats(seathold.getSeatHoldId().intValue(), "test@sbc.com"), equalTo(seathold.getSeatHoldId().intValue()));
	}
	
}