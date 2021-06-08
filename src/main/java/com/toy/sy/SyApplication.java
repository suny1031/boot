package com.toy.sy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SyApplication {


    //@Autowired
    private UserService userScheduler; // 스케줄러

    public static void main(String[] args) {
        SpringApplication.run(SyApplication.class, args);
    }

}
