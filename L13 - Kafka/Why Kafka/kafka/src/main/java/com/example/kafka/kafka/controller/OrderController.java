package com.example.kafka.kafka.controller;

import com.example.kafka.kafka.entities.Orders;
import com.example.kafka.kafka.requests.CreateOrderDto;
import com.example.kafka.kafka.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {


    @Autowired
    OrderService orderService;


    @PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> createAUser(@RequestBody CreateOrderDto orderDto){
        log.info("Request Received {} " , orderDto);
        return new ResponseEntity<>(orderService.createOrder(orderDto), HttpStatus.OK);
    }

}
