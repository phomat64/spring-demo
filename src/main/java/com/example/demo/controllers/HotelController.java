package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.managers.IHotelManager;
import com.example.demo.models.Hotel;

@RestController
@RequestMapping(value = "/service/v1")
public class HotelController {

    @Autowired
    IHotelManager hotelManager;
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("This a test message", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/hotels", method = RequestMethod.GET)
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return new ResponseEntity<>(hotelManager.getAllHotels(), HttpStatus.OK);
    }
    
}
