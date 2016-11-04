package com.wmt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wmt.dao.SeatHoldDAO;
import com.wmt.model.SeatHold;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)

public class TicketServiceDBIntegrationTest {

	@Autowired
	private SeatHoldDAO seatHoldDAO;

	@Test
	public void testNumSeatsAvailable() {
		assertThat(seatHoldDAO.numSeatsAvailable(), is(greaterThanOrEqualTo(0)));
	}
	
	@Test
	public void testFindAndHoldSeats() {
		SeatHold seathold = seatHoldDAO.findAndHoldSeats(1, "test@wmt.com");
		assertThat(seathold.getSeats().size(), is(greaterThan(0)));
	}
	
	@Test
	public void testReserveSeats() {
		assertThat(seatHoldDAO.reserveSeats(1, "test@wmt.com"), equalTo(1));
	}
	
}