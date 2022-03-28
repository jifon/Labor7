package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/former/tour")
public class TourCntrl {
    private final CountryServiceImpl countryServiceImpl;
    private final TypeServiceImpl typeServiceImpl;
    private final TourServiceImpl tourServiceImpl;
    private final TourTaskServiceImpl tourTaskServiceImpl;
    private final HotelServiceImpl hotelServiceImpl;
    private final FlightServiceImpl flightServiceImpl;
    public TourCntrl(CountryServiceImpl countryServiceImpl, TypeServiceImpl typeServiceImpl, TourServiceImpl tourServiceImpl, TourTaskServiceImpl tourTaskServiceImpl, HotelServiceImpl hotelServiceImpl, FlightServiceImpl flightServiceImpl) {
        this.countryServiceImpl = countryServiceImpl;
        this.typeServiceImpl = typeServiceImpl;
        this.tourServiceImpl = tourServiceImpl;
        this.tourTaskServiceImpl = tourTaskServiceImpl;
        this.hotelServiceImpl = hotelServiceImpl;
        this.flightServiceImpl = flightServiceImpl;
    }
    @GetMapping
    public String tourMenu(){
        return "former/tourMenu";
    }
    @GetMapping("/country")
    public String countryList(Model model){
        model.addAttribute("countryList", countryServiceImpl.countryList());
        return "former/countryList";
    }
    @GetMapping("/country/newCountry")
    public String newCountry(Model model){
        model.addAttribute("country", new Country());
        return "former/country_form";
    }
    @PostMapping("/country/save")
    public String createCountry(Country country){
        countryServiceImpl.createCountry(country);
        return "redirect:/former/tour/country";
    }
    @GetMapping("/country/delete/{id}")
    public String deleteCountry(@PathVariable("id") Long id){
        countryServiceImpl.deleteCountry(id);
        return "redirect:/former/tour/country";
    }

    @GetMapping("/types")
    public String types(Model model){
        model.addAttribute("types", typeServiceImpl.typesList());
        return "former/typeList";
    }
    @GetMapping("/types/newType")
    public String newType (Model model){
        model.addAttribute("types", new Types());
        return "former/type_form";
    }
    @PostMapping("/types/save")
    public String createType(Types types){
        typeServiceImpl.createType(types);
        return "redirect:/former/tour/types";
    }
    @GetMapping("/types/delete/{id}")
    public String deleteType(@PathVariable("id") Long id){
        typeServiceImpl.deleteType(id);
        return "redirect:/former/tour/types";
    }

    @GetMapping("/tour-tour")
    public String allTours(Model model){
        model.addAttribute("tours", tourServiceImpl.tourList());
        return "former/tourList";
    }

    @GetMapping("/tour-tour/newTour")
    public String newTour(Model model){
        List<Country> countryList = countryServiceImpl.countryList();
        List<Types> typesList = typeServiceImpl.typesList();
        List<TourTasks> tasksList = tourTaskServiceImpl.tourTasksList();
        model.addAttribute("tours", new Tour());
        model.addAttribute("country", countryList);
        model.addAttribute("types", typesList);
        model.addAttribute("tasks", tasksList);
        return "former/tour_form";
    }
    @PostMapping("/tour-tour/save")
    public String createTour(Tour tour){
        tourServiceImpl.creatTour(tour);
        return "redirect:/former/tour/tour-tour";
    }
    @GetMapping("/tour-tour/edit/{id}")
    public String editTour(@PathVariable(name = "id") Long id, Model model){
        Tour tour = tourServiceImpl.findTourById(id);
        model.addAttribute("tours", tour);
        List<Country> countryList = countryServiceImpl.countryList();
        List<Types> typesList = typeServiceImpl.typesList();
        model.addAttribute("country", countryList);
        model.addAttribute("types", typesList);
        return "former/tour_form";
    }
    @GetMapping("/tour-tour/delete/{id}")
    public String deleteTour(@PathVariable("id") Long id){
        tourServiceImpl.deleteTour(id);
        return "redirect:/former/tour/tour-tour";
    }

    @GetMapping("/hotel")
    public String hotelList(Model model){
        model.addAttribute("hotels", hotelServiceImpl.hotelList());
        return "former/hotelList";
    }

    @GetMapping("/hotel/newHotel")
    public String newHotel(Model model){
        List<Tour> tourList = tourServiceImpl.tourList();
        model.addAttribute("tours", tourList);
        model.addAttribute("hotel", new Hotel());
        return "former/hotel_form";
    }
    @PostMapping("/hotel/save")
    public String createHotel(Hotel hotel){
        hotelServiceImpl.createHotel(hotel);
        return "redirect:/former/tour/hotel";
    }
    @GetMapping("/hotel/edit/{id}")
    public String editHotel(@PathVariable("id") Long id, Model model){
        Hotel hotel = hotelServiceImpl.updateById(id);
        model.addAttribute("hotel", hotel);
        List<Tour> tourList = tourServiceImpl.tourList();
        model.addAttribute("tours", tourList);
        return "former/hotel_form";
    }
    @GetMapping("/hotel/delete/{id}")
    public String deleteHotel(@PathVariable Long id){
        hotelServiceImpl.deleteHotel(id);
        return "redirect:/former/tour/hotel";

    }

    @GetMapping("/room")
    public String roomList(Model model){
        model.addAttribute("room", hotelServiceImpl.roomsList());
        return "former/roomList";
    }

    @GetMapping("/room/newRoom")
    public String createRoom(Model model){
        List<Hotel> hotelList = hotelServiceImpl.hotelList();
        model.addAttribute("room", new HotelRooms());
        model.addAttribute("hotel", hotelList);
        return "former/room_form";
    }
    @PostMapping("/room/save")
    public String save(HotelRooms rooms){
        hotelServiceImpl.createRoom(rooms);
        return "redirect:/former/tour/room";
    }
    @GetMapping("/room/edit/{id}")
    public String editRoom(@PathVariable("id") Long id, Model model){
        HotelRooms room = hotelServiceImpl.updateRoom(id);
        List<Hotel> hotelList = hotelServiceImpl.hotelList();
        model.addAttribute("room" , room);
        model.addAttribute("hotel", hotelList);
        return "former/room_form";
    }
    @GetMapping("/room/delete/{id}")
    public String deleteRoom(@PathVariable("id") Long id){
        hotelServiceImpl.deleteRoom(id);
        return "redirect:/former/tour/room";
    }

    @GetMapping("/flight")
    public String flightList(Model model){
        model.addAttribute("flight", flightServiceImpl.flightsList());
        return "former/flightList";
    }
    @GetMapping("/flight/newFlight")
    public String createFlight(Model model){
        List<Tour> tourList = tourServiceImpl.tourList();
        model.addAttribute("tour", tourList);
        model.addAttribute("flight", new TourFlights());
        return "former/flight_form";
    }
    @PostMapping("/flight/save")
    public String saving(TourFlights flights){
        flightServiceImpl.createFlight(flights);
        return "redirect:/former/tour/flight";
    }
    @GetMapping("/flight/edit/{id}")
    public String editFlight(@PathVariable("id") Long id, Model model){
        TourFlights flights = flightServiceImpl.updateFlights(id);
        model.addAttribute("flight", flights);
        List<Tour> tours = tourServiceImpl.tourList();
        model.addAttribute("tour", tours);
        return "former/flight_form";
    }
    @GetMapping("/flight/delete/{id}")
    public String deleteFlight(@PathVariable("id") Long id){
        flightServiceImpl.deleteFlight(id);
        return "redirect:/former/tour/flight";
    }

    @GetMapping("/ticket")
    public String ticketList(Model model){
        model.addAttribute("ticket", flightServiceImpl.ticketList());
        return "former/ticketList";
    }
    @GetMapping("/ticket/newTicket")
    public String newTicket(Model model){
        List<TourFlights> flights = flightServiceImpl.flightsList();
        model.addAttribute("flight", flights);
        model.addAttribute("ticket", new AirTicket());
        return "former/ticket_form";
    }
    @PostMapping("/ticket/save")
    public String saveTicket(AirTicket ticket){
        flightServiceImpl.createTicket(ticket);
        return "redirect:/former/tour/ticket";
    }
    @GetMapping("/ticket/edit/{id}")
    public String updateTicket(@PathVariable("id") Long id, Model model){
        AirTicket ticket = flightServiceImpl.updateTicket(id);
        List<TourFlights> flights = flightServiceImpl.flightsList();
        model.addAttribute("ticket", ticket);
        model.addAttribute("flight", flights);
        return "former/ticket_form";
    }
    @GetMapping("/ticket/delete/{id}")
    public String deleteTicket(@PathVariable("id") Long id){
        flightServiceImpl.deleteTicket(id);
        return "redirect:/former/tour/ticket";
    }









}
