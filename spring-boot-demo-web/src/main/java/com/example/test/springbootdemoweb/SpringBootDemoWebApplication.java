package com.example.test.springbootdemoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heipai
 */
@SpringBootApplication
@RestController
@RequestMapping("/spring-boot-web")
public class SpringBootDemoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoWebApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return " hello spring boot web";
    }
}
