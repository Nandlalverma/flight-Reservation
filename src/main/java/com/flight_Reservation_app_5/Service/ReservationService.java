package com.flight_Reservation_app_5.Service;

import com.flight_Reservation_app_5.dto.ReservationRequest;
import com.flight_Reservation_app_5.entity.Reservation;

public interface ReservationService {
     
	Reservation bookFlight(ReservationRequest request);
}
