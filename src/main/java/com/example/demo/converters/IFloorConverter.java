package com.example.demo.converters;

import com.example.demo.domain.DbFloor;
import com.example.demo.domain.DbHotel;
import com.example.demo.models.Floor;

public interface IFloorConverter {

    Floor convertToView(DbFloor dbFloor);

    DbFloor convertToDomain(Floor floor, DbHotel dbHotel);
    
}
