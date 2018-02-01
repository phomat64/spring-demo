package com.example.demo.models;

import java.util.List;
import java.util.Objects;

public class Room {

    private Long id;
    
    private Long floorId;
    
    private String name;
    
    private List<Compartment> compartments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Compartment> getCompartments() {
        return compartments;
    }

    public void setCompartments(List<Compartment> compartments) {
        this.compartments = compartments;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return Objects.equals(id, room.id) &&
               Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    
}
