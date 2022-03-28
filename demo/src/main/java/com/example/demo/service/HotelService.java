package com.example.demo.service;

import com.example.demo.model.Hotel;
import com.example.demo.model.HotelRooms;

import java.util.List;

public interface HotelService {
    public List<Hotel> hotelList();
    public void createHotel(Hotel hotel);
    public Hotel updateById(Long id);
    public void deleteHotel(Long id);
    public List<HotelRooms> roomsList();
    public void createRoom(HotelRooms rooms);
    public HotelRooms updateRoom(Long id);
    public void deleteRoom(Long id);
}
