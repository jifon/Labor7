package com.example.demo.repository;

import com.example.demo.model.AirTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirTicketRep extends JpaRepository<AirTicket, Long> {
}
