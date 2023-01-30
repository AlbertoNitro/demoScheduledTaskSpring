package com.inditex.demoTaskScheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PingController.PING)
public class PingController {
    public static final String PING = "/ping";

    @Autowired
    public PingController() {
    }

    @GetMapping()
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

}
