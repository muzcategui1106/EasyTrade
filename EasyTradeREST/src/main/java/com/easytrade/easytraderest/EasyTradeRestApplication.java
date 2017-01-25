package com.easytrade.easytraderest;

import com.easytrade.easytradelib.EasyTradeLibApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(EasyTradeLibApplication.class)
public class EasyTradeRestApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger( EasyTradeRestApplication.class.getName() );

	public static void main(String[] args) {
		LOGGER.info("Starting EasyTrade REST service");
		SpringApplication.run(EasyTradeRestApplication.class, args);
		LOGGER.info("Succesfully started EasyTrade REST service");
	}
}
