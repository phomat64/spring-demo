package com.example.demo.managers;

import java.util.List;

import com.example.demo.models.Hotel;

public interface IHotelManager {
    
    public List<Hotel> getAllHotels();
    
    public Hotel getHotelByName(String name);
    
    public Hotel createHotel(Hotel hotel);
    
    public Hotel updateHotel(Hotel hotel);
    
    public void deleteHotel(Long id);
    
}
