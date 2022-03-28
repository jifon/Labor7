package com.example.demo.model;

import com.example.demo.model.constant.HotelClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
@Data@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;

    private String name;

    @Enumerated(EnumType.STRING)
    private HotelClass hotelClass;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;




}
