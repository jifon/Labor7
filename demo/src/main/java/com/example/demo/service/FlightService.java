package com.example.demo.service;

import com.example.demo.model.AirTicket;
import com.example.demo.model.TourFlights;

import java.util.List;

public interface FlightService {
    public List<TourFlights> flightsList();
    public void createFlight(TourFlights flights);
    public TourFlights updateFlights(Long id);
    public void deleteFlight(Long id);
    public List<AirTicket> ticketList();
    public void createTicket(AirTicket ticket);
    public AirTicket updateTicket(Long id);
    public void deleteTicket(Long id);

}
