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
@Table(name = "rooms")
public class DbRoom {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "floor_id")
    private DbFloor floor;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<DbCompartment> compartments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DbFloor getFloor() {
        return floor;
    }

    public void setFloor(DbFloor floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DbCompartment> getCompartments() {
        return compartments;
    }

    public void setCompartments(Set<DbCompartment> compartments) {
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
        DbRoom dbRoom = (DbRoom) o;
        return Objects.equals(id, dbRoom.id) &&
               Objects.equals(name, dbRoom.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
