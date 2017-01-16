package com.sbc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.sbc.dao.SeatHoldDAO;
import com.sbc.model.SeatHold;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)

public class TicketServiceRestIntegrationTest {
	
	@Autowired
	@Qualifier("seatHoldDAOTest")
	private SeatHoldDAO seatHoldDAOTest;
	
	@Test
	public void testURISeats() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(
				"http://localhost:8090/seats", String.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void testURIHold() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("numSeats", "1");
		params.put("customerEmail", "prod-hold-test@sbc.com");
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity entity = new HttpEntity(headers);

		ResponseEntity<String> response = 
				restTemplate.exchange("http://localhost:8090/hold?numSeats={numSeats}&customerEmail={customerEmail}", 
				HttpMethod.PUT, entity, String.class, params);		
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void testURIReserve() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		
		SeatHold seathold = seatHoldDAOTest.findAndHoldSeats(1, "prod-res-test@sbc.com");
		Map<String, String> params = new HashMap<String, String>();
		params.put("seatHoldId", seathold.getSeatHoldId().toString());
		params.put("customerEmail", seathold.getEmail());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity entity = new HttpEntity(headers);

		ResponseEntity<String> response = 
				restTemplate.exchange("http://localhost:8090/reserve?seatHoldId={seatHoldId}&customerEmail={customerEmail}", 
				HttpMethod.PUT, entity, String.class, params);		
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
}
