package com.sbc.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbc.common.RestApiResponse;
import com.sbc.common.RestApiResponse.RestApiError;
import com.sbc.common.RestApiResponse.Status;
import com.sbc.dao.SeatHoldDAO;
import com.sbc.model.SeatHold;

@RestController
@Validated
public class TicketingController {

	// private TicketService ticketService;

	@Autowired
	private SeatHoldDAO seatHoldDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Welcome to your ticketing service\n";
	}
	
	@RequestMapping(value = "/seats", method = RequestMethod.GET)
	public RestApiResponse getNumOfSeats() {
		int numSeats = seatHoldDAO.numSeatsAvailable();
		if (numSeats <= 0)
			return new RestApiResponse(Status.ERROR, null, new RestApiError(1,
					"Unable to find seats. No more seats available."));

		return new RestApiResponse(Status.OK, numSeats);
	}

	@RequestMapping(value = "/hold", method = RequestMethod.GET)
	public String hold() {
		return "Send me valid hold request\n";
	}

	// URI Pattern : /hold ? numSeats=NNN & customerEmail=AAA
	@RequestMapping(value = "/hold", method = RequestMethod.PUT)
	public RestApiResponse findAndHoldSeats(
			@Min(value=1, message = "Atleast 1 seat should be requested for hold")
			@Max(value=10, message = "Maximum 10 seats can be requested for hold") 
			@RequestParam(value = "numSeats", required = true) int numSeats,
			@Email(message="Invalid Customer EmailId") 
			@RequestParam(value = "customerEmail", required = true) String customerEmail) {
		
		try {
			SeatHold seatHold = seatHoldDAO.findAndHoldSeats(numSeats,
					customerEmail);

			if (seatHold.getSeats().size() <= 0)
				return new RestApiResponse(Status.ERROR, null,
						new RestApiError(2, "Unable to hold " + numSeats
								+ " seats. No more seats available."));

			return new RestApiResponse(Status.OK, seatHold);

		} catch (ConstraintViolationException c) {
			return handleRequestParamValidationErrors(c);
		} catch (RuntimeException e) {
			return new RestApiResponse(Status.ERROR, null, new RestApiError(3,
					"Unable to hold " + numSeats + " seats"));
		}

	}

	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public String reserve() {
		return "Send me valid reserve request\n";
	}

	// URI Pattern : /reserve ? seatHoldId=NNN & customerEmail=AAA
	@RequestMapping(value = "/reserve", method = RequestMethod.PUT)
	public RestApiResponse reserveSeats(
			@Min(value=0, message = "Invalid seatHoldId")
			@RequestParam(value = "seatHoldId", required = true) int seatHoldId,
			@Email(message="Invalid Customer EmailId") 
			@RequestParam(value = "customerEmail", required = true) String customerEmail) {
		
		try {
			int confirmationCode = seatHoldDAO.reserveSeats(seatHoldId,
					customerEmail);
			
			if (confirmationCode <= 0)
				return new RestApiResponse(
						Status.ERROR, null,
						new RestApiError(4, "Unable to reserve seats. Possible reasons: Already reserved to same "
								+ "seatHoldId & customerEmail, invalid seatHoldId or customerEmail"));

			return new RestApiResponse(Status.OK, new String(
					"confirmationCode=" + confirmationCode));

		} catch (ConstraintViolationException c) {
			return handleRequestParamValidationErrors(c);
		} catch (RuntimeException e) {
			return new RestApiResponse(Status.ERROR, null, new RestApiError(2,
					"Unable to reserve seats for seatHoldId : " + seatHoldId));
		}
	}

	@ExceptionHandler(value = { ConstraintViolationException.class })
	public RestApiResponse handleRequestParamValidationErrors(
			ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		StringBuilder strBuilder = new StringBuilder();
		
		for (ConstraintViolation<?> violation : violations) {
			strBuilder.append(violation.getMessage() + "\n");
		}
		return new RestApiResponse(Status.ERROR, null, new RestApiError(5,
				strBuilder.toString()));
	}
}