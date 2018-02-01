package com.example.demo.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "floors")
public class DbFloor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private DbHotel hotel;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private Set<DbRoom> rooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DbHotel getHotel() {
        return hotel;
    }

    public void setHotel(DbHotel hotel) {
        this.hotel = hotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DbRoom> getRooms() {
        return rooms;
    }

    public void setRooms(Set<DbRoom> rooms) {
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
        DbFloor dbFloor = (DbFloor) o;
        return Objects.equals(id, dbFloor.id) &&
               Objects.equals(name, dbFloor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    
}
