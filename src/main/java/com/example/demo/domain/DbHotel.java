package com.example.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.ras.converters.LocalDateTimeConverter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "hotels")
public class DbHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "open_date")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDate openDate;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<DbFloor> floors;

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

    public Set<DbFloor> getFloors() {
        return floors;
    }

    public void setFloors(Set<DbFloor> floors) {
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
        DbHotel dbHotel = (DbHotel) o;
        return Objects.equals(id, dbHotel.id) &&
               Objects.equals(name, dbHotel.name) &&
               Objects.equals(openDate, dbHotel.openDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, openDate);
    }
    
}

