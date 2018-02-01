package com.example.demo.converters;

import com.example.demo.domain.DbFloor;
import com.example.demo.domain.DbRoom;
import com.example.demo.models.Room;

public interface IRoomConverter {

    Room convertToView(DbRoom dbRoom);

    DbRoom convertToDomain(Room room, DbFloor dbFloor);
    
}
