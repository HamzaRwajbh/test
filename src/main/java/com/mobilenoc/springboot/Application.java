package com.mobilenoc.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String []args){
        SpringApplication.run(Application.class,args);
        String link = "http:localhost/student" ;
        LOGGER.info("----------------------------------------------------------");
        LOGGER.info("Application is running! Access URLs:"+ link);
        LOGGER.info("----------------------------------------------------------");

    }
}
