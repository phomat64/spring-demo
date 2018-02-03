package com.example.demo.ras.postgres;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.DbFloor;

@Repository
@Transactional
public interface IFloorRepository extends JpaRepository<DbFloor, Long> {

}
