package com.example.demo.converters.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.converters.ICompartmentConverter;
import com.example.demo.converters.IRoomConverter;
import com.example.demo.domain.DbFloor;
import com.example.demo.domain.DbRoom;
import com.example.demo.models.Room;

@Component
public class RoomConverter implements IRoomConverter {

    @Autowired
    private ICompartmentConverter compartmentConverter;

    @Override
    public Room convertToView(DbRoom dbRoom) {
        if (dbRoom == null) {
            return null;
        }
        
        Room room = new Room();
        room.setId(dbRoom.getId());
        room.setFloorId(dbRoom.getFloor().getId());
        room.setName(dbRoom.getName());
        room.setCompartments(dbRoom.getCompartments()
                               .stream()
                               .map(dbCompartment -> compartmentConverter.convertToView(dbCompartment))
                               .collect(Collectors.toList()));
        return room;
    }

    @Override
    public DbRoom convertToDomain(Room room, DbFloor dbFloor) {
        if (room == null) {
            return null;
        }
        
        DbRoom dbRoom = new DbRoom();
        dbRoom.setId(room.getId());
        dbRoom.setName(room.getName());
        dbRoom.setFloor(dbFloor);
        dbRoom.setCompartments(room.getCompartments()
                               .stream()
                               .map(compart -> compartmentConverter.convertToDomain(compart, dbRoom))
                               .collect(Collectors.toSet()));
        
        return dbRoom;
    }
    
}
