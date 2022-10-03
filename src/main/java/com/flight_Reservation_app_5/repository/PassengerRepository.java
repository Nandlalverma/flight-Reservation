package com.flight_Reservation_app_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_Reservation_app_5.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Long>{
	

}
