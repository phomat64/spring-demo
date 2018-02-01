package com.example.demo.models;

import java.util.Objects;

public class Compartment {

    private Long id;
    
    private Long roomId;
    
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Compartment compartment = (Compartment) o;
        return Objects.equals(id, compartment.id) &&
               Objects.equals(name, compartment.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    
}
