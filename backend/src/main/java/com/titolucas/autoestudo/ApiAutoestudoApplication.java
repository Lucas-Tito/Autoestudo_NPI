package com.titolucas.autoestudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ApiAutoestudoApplication {

	private static final Logger logger = LoggerFactory.getLogger(ApiAutoestudoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApiAutoestudoApplication.class, args);

		logger.info("======================================");
		logger.info("It was too big to be called a sword");
		logger.info("======================================");
	}

}
