package com.example.demo.model;


import com.example.demo.model.constant.HotelRoomCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="hotel_rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelRooms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "check_in")
    private Date checkIn;

    @Column(name = "room_number")
    private int roomNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "check_out")
    private Date check_out;

    @Enumerated(EnumType.STRING)
    private HotelRoomCategory hotelRoomCategory;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToMany
    @JoinTable(name = "hotelRooms_travelPackage",
    joinColumns = @JoinColumn(name = "hotel_room_id"),
    inverseJoinColumns = @JoinColumn(name = "travel_package_id"))
    private List<TravelPackage> travelPackageList;
}
