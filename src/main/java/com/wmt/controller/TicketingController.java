package com.wmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wmt.common.RestApiResponse;
import com.wmt.common.RestApiResponse.RestApiError;
import com.wmt.common.RestApiResponse.Status;
import com.wmt.model.SeatHold;
import com.wmt.dao.SeatHoldDAO;

@RestController
public class TicketingController {

	// private TicketService ticketService;

	@Autowired
	private SeatHoldDAO seatHoldDAO;

	@RequestMapping("/")
	public String home() {
		return "Welcome to your ticketing service";
	}

	@RequestMapping(value = "/seats", method = RequestMethod.GET)
	public int getNumOfSeats() {
		return seatHoldDAO.numSeatsAvailable();
	}

	// URI Pattern : /hold ? numSeats=NNN & customerEmail=AAA
	@RequestMapping(value = "/hold", method = RequestMethod.PUT)
	public RestApiResponse findAndHoldSeats(
			@RequestParam(value = "numSeats", required = true) int numSeats,
			@RequestParam(value = "customerEmail", required = true) String customerEmail) {
		try {
			SeatHold seatHold = seatHoldDAO.findAndHoldSeats(numSeats,
					customerEmail);
			return new RestApiResponse(Status.OK, seatHold);
		} catch (RuntimeException e) {
			return new RestApiResponse(Status.ERROR, null, new RestApiError(1,
					"Unable to hold " + numSeats + " seats"));
		}
	}

	// URI Pattern : /reserve ? seatHoldId=NNN & customerEmail=AAA
	@RequestMapping(value = "/reserve", method = RequestMethod.PUT)
	public RestApiResponse reserveSeats(
			@RequestParam(value = "seatHoldId", required = true) int seatHoldId,
			@RequestParam(value = "customerEmail", required = true) String customerEmail) {
		try {
			int confirmationCode = seatHoldDAO.reserveSeats(seatHoldId,
					customerEmail);
			return new RestApiResponse(Status.OK, confirmationCode);
		} catch (RuntimeException e) {
			return new RestApiResponse(Status.ERROR, null, new RestApiError(2,
					"Unable to reserve seats for seatHoldId : " + seatHoldId));
		}
	}
}
