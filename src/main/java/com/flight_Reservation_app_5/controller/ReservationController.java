package com.flight_Reservation_app_5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight_Reservation_app_5.Service.ReservationService;
import com.flight_Reservation_app_5.dto.ReservationRequest;
import com.flight_Reservation_app_5.entity.Reservation;
import com.flight_Reservation_app_5.utility.PDFgenerator;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/completeReservation")
	public String confirmReservation(ReservationRequest reservation, ModelMap modelMap) {
		 Reservation reservationId = reservationService.bookFlight(reservation);
		 modelMap.addAttribute("reversionId", reservationId.getId());
		
		 
		 
		 //System.out.println(reservation.getEmail());
		//System.out.println(reservation.getFlightId());
		 
		return "conformReservation";
	}
}
