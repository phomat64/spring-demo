package com.example.demo.converters.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.converters.ICompartmentConverter;
import com.example.demo.domain.DbCompartment;
import com.example.demo.domain.DbFloor;
import com.example.demo.domain.DbRoom;
import com.example.demo.models.Compartment;
import com.example.demo.models.Room;

@Component
public class CompartmentConverter implements ICompartmentConverter {

    @Override
    public Compartment convertToView(DbCompartment dbCompartment) {
        if (dbCompartment == null) {
            return null;
        }
        
        Compartment compartment = new Compartment();
        compartment.setId(dbCompartment.getId());
        compartment.setRoomId(dbCompartment.getRoom().getId());
        compartment.setName(dbCompartment.getName());
        return compartment;
    }

    @Override
    public DbCompartment convertToDomain(Compartment compartment, DbRoom dbRoom) {
        if (compartment == null) {
            return null;
        }
        
        DbCompartment dbCompartment = new DbCompartment();
        dbCompartment.setId(compartment.getId());
        dbCompartment.setName(compartment.getName());
        dbCompartment.setRoom(dbRoom);
        
        return dbCompartment;
    }
    
}
