package com.tennismaniac.tennismaniacrest;

import com.tennismaniac.tennismaniaclib.TennisManiacLibApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(TennisManiacLibApplication.class)
public class TennisManiacRestApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(TennisManiacRestApplication.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Starting tennismaniac REST service");
        SpringApplication.run(TennisManiacRestApplication.class, args);
        LOGGER.info("Succesfully started tennismaniac REST service");
    }
}
