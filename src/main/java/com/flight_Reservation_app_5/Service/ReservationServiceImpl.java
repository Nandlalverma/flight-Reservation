package com.flight_Reservation_app_5.Service;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight_Reservation_app_5.dto.ReservationRequest;
import com.flight_Reservation_app_5.entity.Flight;
import com.flight_Reservation_app_5.entity.Passenger;
import com.flight_Reservation_app_5.entity.Reservation;
import com.flight_Reservation_app_5.repository.FlightRepository;
import com.flight_Reservation_app_5.repository.PassengerRepository;
import com.flight_Reservation_app_5.repository.ReservationRepository;
import com.flight_Reservation_app_5.utility.PDFgenerator;
import com.itextpdf.text.Document;

@Service
public class ReservationServiceImpl implements ReservationService{

	
	@Autowired
	 private PassengerRepository passengerRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		
		String filePath="C:\\Users\\hp\\OneDrive\\Desktop";
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepository.save(passenger);
		long flightId = request.getFlightId();
		
		Optional<Flight> findById = flightRepository.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		
		reservationRepository.save(reservation);
		/*
		 * private static void addTitleTable(Document document, String name, String
		 * emailId, String phone, String operatingArilines, String departureDate, String
		 * departureCity, String arrivalCity)
		 */
		
		
		PDFgenerator pdf=new PDFgenerator();
		pdf.generatePDF(filePath+reservation.getId()+".pdf", request.getFirstName(),
				request.getEmail(), request.getPhone(),flight.getDepartureCity()
				 ,flight.getDepartureCity(), flight.getDepartureCity()
				 , flight.getArrivalCity());
				
		
		return reservation;
	}

}
