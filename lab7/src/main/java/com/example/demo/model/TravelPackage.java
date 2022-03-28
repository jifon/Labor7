package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tour")
@AllArgsConstructor
@NoArgsConstructor
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "travel_package_number")
    private int travelPackageNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToMany
    @JoinTable(name = "travelPackage_airTicket",
    joinColumns = @JoinColumn(name = "travel_package_id"),
    inverseJoinColumns = @JoinColumn(name = "air_ticket_id"))
    private List<AirTicket> airTicketList;

    @ManyToMany
    @JoinTable(name = "hotelRooms_travelPackage",
            joinColumns = @JoinColumn(name = "travel_package_id"),
            inverseJoinColumns = @JoinColumn(name = "hotel_room_id"))
    private List<HotelRooms> hotelRoomsList;

    @ManyToMany
    @JoinTable(name = "travelPackage_eventTickets",
            joinColumns = @JoinColumn(name = "travel_package_id"),
            inverseJoinColumns = @JoinColumn(name = "event_tickets_id"))
    private List<EventTickets> eventTicketsList;




}

