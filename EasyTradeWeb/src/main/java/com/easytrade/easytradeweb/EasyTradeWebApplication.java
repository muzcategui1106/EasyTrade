package com.easytrade.easytradeweb;

import com.easytrade.easytraderest.EasyTradeRestApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(EasyTradeRestApplication.class)
public class EasyTradeWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyTradeWebApplication.class, args);
	}
}
