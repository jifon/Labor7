package com.example.demo.repository;

import com.example.demo.model.TourFlights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourFlightsRep extends JpaRepository<TourFlights, Long> {
}
