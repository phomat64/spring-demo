package com.example.demo.converters.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.converters.IFloorConverter;
import com.example.demo.converters.IRoomConverter;
import com.example.demo.domain.DbFloor;
import com.example.demo.domain.DbHotel;
import com.example.demo.models.Floor;

@Component
public class FloorConverter implements IFloorConverter {
    
    @Autowired
    private IRoomConverter roomConverter;

    @Override
    public Floor convertToView(DbFloor dbFloor) {
        if (dbFloor == null) {
            return null;
        }
        
        Floor floor = new Floor();
        floor.setId(dbFloor.getId());
        floor.setHotelId(dbFloor.getHotel().getId());
        floor.setName(dbFloor.getName());
        floor.setRooms(dbFloor.getRooms()
                               .stream()
                               .map(dbRoom -> roomConverter.convertToView(dbRoom))
                               .collect(Collectors.toList()));
        return floor;
    }

    @Override
    public DbFloor convertToDomain(Floor floor, DbHotel dbHotel) {
        if (floor == null) {
            return null;
        }
        
        DbFloor dbFloor = new DbFloor();
        dbFloor.setId(floor.getId());
        dbFloor.setName(floor.getName());
        dbFloor.setHotel(dbHotel);
        dbFloor.setRooms(floor.getRooms()
                               .stream()
                               .map(room -> roomConverter.convertToDomain(room, dbFloor))
                               .collect(Collectors.toSet()));
        return dbFloor;
    }

}
