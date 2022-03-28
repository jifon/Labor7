package com.example.demo.service;

import com.example.demo.model.Hotel;
import com.example.demo.model.HotelRooms;
import com.example.demo.repository.HotelRep;
import com.example.demo.repository.HotelRoomsRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRep hotelRep;
    private final HotelRoomsRep hotelRoomsRep;

    public HotelServiceImpl(HotelRep hotelRep, HotelRoomsRep hotelRoomsRep) {
        this.hotelRep = hotelRep;
        this.hotelRoomsRep = hotelRoomsRep;
    }

    @Override
    public List<Hotel> hotelList(){
        return hotelRep.findAll();
    }

    @Override
    public void createHotel(Hotel hotel){
        hotelRep.save(hotel);
    }

    @Override
    public Hotel updateById(Long id){
        return hotelRep.findById(id).get();
    }

    @Override
    public void deleteHotel(Long id){
        hotelRep.deleteById(id);
    }

    @Override
    public List<HotelRooms> roomsList(){
        return hotelRoomsRep.findAll();
    }

    @Override
    public void createRoom(HotelRooms rooms){
        hotelRoomsRep.save(rooms);
    }

    @Override
    public HotelRooms updateRoom(Long id){
        return hotelRoomsRep.findById(id).get();
    }

    @Override
    public void deleteRoom(Long id){
        hotelRoomsRep.deleteById(id);
    }
}
