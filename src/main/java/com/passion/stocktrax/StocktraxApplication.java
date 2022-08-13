package com.passion.stocktrax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class StocktraxApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocktraxApplication.class, args);

	}

}
