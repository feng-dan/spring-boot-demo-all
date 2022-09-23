package com.example.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fengdan
 */
@Slf4j
@SpringBootApplication
public class ApplicationTestDemo {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationTestDemo.class, args);
        log.info("startup complete");
    }
}