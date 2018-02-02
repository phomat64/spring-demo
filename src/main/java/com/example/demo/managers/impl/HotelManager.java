package com.example.demo.managers.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.converters.IHotelConverter;
import com.example.demo.domain.DbHotel;
import com.example.demo.managers.IHotelManager;
import com.example.demo.models.Hotel;
import com.example.demo.ras.postgres.IHotelRepository;

@Component
public class HotelManager implements IHotelManager {
    
    @Autowired
    private IHotelRepository hotelRepository;
    
    @Autowired
    private IHotelConverter hotelConverter;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll()
                              .stream()
                              .map(hotelConverter::convertToView)
                              .collect(Collectors.toList());
    }

    @Override
    public Hotel getHotelByName(String name) {
        if (name == null) {
            throw new EntityNotFoundException("Unable to retrieve Hotel with name: " + name);
        }
        return hotelConverter.convertToView(hotelRepository.findByName(name));
    }

    @Override
    @Transactional
    public Hotel createHotel(Hotel hotel) {
        DbHotel dbHotel = hotelRepository.save(hotelConverter.convertToDomain(hotel));
        return hotelConverter.convertToView(dbHotel);
    }

    @Override
    @Transactional
    public Hotel updateHotel(Hotel hotel) {
        DbHotel dbHotel = hotelRepository.findOne(hotel.getId());
        if (dbHotel == null) {
            throw new EntityNotFoundException("Unable to retrieve Hotel with id: " + hotel.getId());
        }
        
        dbHotel = hotelRepository.save(hotelConverter.convertToDomain(hotel));
        return hotelConverter.convertToView(dbHotel);
    }

    @Override
    @Transactional
    public void deleteHotel(Long id) {
        hotelRepository.delete(id);
    }

}
