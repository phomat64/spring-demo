package com.example.demo.converters;

import com.example.demo.domain.DbHotel;
import com.example.demo.models.Hotel;

public interface IHotelConverter {

    Hotel convertToView(DbHotel dbHotel);

    DbHotel convertToDomain(Hotel hotel);

}
