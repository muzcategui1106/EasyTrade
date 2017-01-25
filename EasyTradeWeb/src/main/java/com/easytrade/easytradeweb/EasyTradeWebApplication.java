package com.easytrade.easytradeweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EasyTradeWebApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(EasyTradeWebApplication.class);

	public static void main(String[] args) {
	    LOGGER.info("Starting EasyTrade Application");
	    // TODO configure logback.xml parameter
		SpringApplication.run(EasyTradeWebApplication.class, args);

	}
}
