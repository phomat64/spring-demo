package com.example.demo.converters.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.converters.IFloorConverter;
import com.example.demo.converters.IHotelConverter;
import com.example.demo.domain.DbHotel;
import com.example.demo.models.Hotel;

@Component
public class HotelConverter implements IHotelConverter {
    
    @Autowired
    private IFloorConverter floorConverter;

    @Override
    public Hotel convertToView(DbHotel dbHotel) {
        if (dbHotel == null) {
            return null;
        }
        
        Hotel hotel = new Hotel();
        hotel.setId(dbHotel.getId());
        hotel.setName(dbHotel.getName());
        hotel.setOpenDate(dbHotel.getOpenDate());
        hotel.setFloors(dbHotel.getFloors()
                               .stream()
                               .map(dbFloor -> floorConverter.convertToView(dbFloor))
                               .collect(Collectors.toList()));
        
        return hotel;
    }

    @Override
    public DbHotel convertToDomain(Hotel hotel) {
        if (hotel == null) {
            return null;
        }
        
        DbHotel dbHotel = new DbHotel();
        dbHotel.setId(hotel.getId());
        dbHotel.setName(hotel.getName());
        dbHotel.setOpenDate(hotel.getOpenDate());
        dbHotel.setFloors(hotel.getFloors()
                               .stream()
                               .map(floor -> floorConverter.convertToDomain(floor, dbHotel))
                               .collect(Collectors.toSet()));
        return dbHotel;
    }

}
