package com.example.demo.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Hotel {

    private Long id;
    
    private String name;
    
    private LocalDate openDate;
    
    private List<Floor> floors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id) &&
               Objects.equals(name, hotel.name) &&
               Objects.equals(openDate, hotel.openDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, openDate);
    }
    
}
