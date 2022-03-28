package com.example.demo.service;

import com.example.demo.model.AirTicket;
import com.example.demo.model.TourFlights;
import com.example.demo.repository.AirTicketRep;
import com.example.demo.repository.TourFlightsRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private final TourFlightsRep tourFlightsRep;
    private final AirTicketRep ticketRepository;

    public FlightServiceImpl(TourFlightsRep tourFlightsRep, AirTicketRep ticketRepository) {
        this.tourFlightsRep = tourFlightsRep;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TourFlights> flightsList(){
        return tourFlightsRep.findAll();
    }

    @Override
    public void createFlight(TourFlights flights){
        tourFlightsRep.save(flights);
    }

    @Override
    public TourFlights updateFlights(Long id){
        return tourFlightsRep.findById(id).get();
    }

    @Override
    public void deleteFlight(Long id){
        tourFlightsRep.deleteById(id);
    }

    @Override
    public List<AirTicket> ticketList(){
        return  ticketRepository.findAll();
    }

    @Override
    public void createTicket(AirTicket ticket){
        ticketRepository.save(ticket);
    }

    @Override
    public AirTicket updateTicket(Long id){
        return ticketRepository.findById(id).get();
    }

    @Override
    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);
    }


}
