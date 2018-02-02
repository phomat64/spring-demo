package com.example.demo.ras.postgres;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.DbHotel;

@Repository
public interface IHotelRepository extends JpaRepository<DbHotel, Long> {
    
    DbHotel findByName(String name);

}
