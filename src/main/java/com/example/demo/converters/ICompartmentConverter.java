package com.example.demo.converters;

import com.example.demo.domain.DbCompartment;
import com.example.demo.domain.DbRoom;
import com.example.demo.models.Compartment;

public interface ICompartmentConverter {
    
    Compartment convertToView(DbCompartment dbCompartment);

    DbCompartment convertToDomain(Compartment compartment, DbRoom dbRoom);

}
