package com.example.demo.models;

import java.util.List;
import java.util.Objects;

public class Floor {
    
    private Long id;
    
    private Long hotelId;
    
    private String name;
    
    private List<Room> rooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Floor floor = (Floor) o;
        return Objects.equals(id, floor.id) &&
               Objects.equals(name, floor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
