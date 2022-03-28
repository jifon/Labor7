package com.example.demo.repository;

import com.example.demo.model.HotelRooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomsRep extends JpaRepository<HotelRooms, Long> {
}
