package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tour_flight")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourFlights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_code")
    private String flightCode;

    private String airline;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "departure_city")
    private String departureCity;

    @Column(name = "city_of_arrival")
    private String cityOfArrival;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;




}
