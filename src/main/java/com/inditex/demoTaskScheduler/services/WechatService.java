package com.inditex.demoTaskScheduler.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class WechatService {

    @Autowired
    public WechatService() {
    }

    private static String generateRandomToken() {
        String token = UUID.randomUUID().toString();
        log.info("generated new token = " + token);
        return token;
    }
    
    public String getAccessToken() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return generateRandomToken();
    }
}