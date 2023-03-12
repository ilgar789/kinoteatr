package com.cinema.kinoteatr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.websocket.server.ServerEndpoint;

@SpringBootApplication
public class KinoteatrApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinoteatrApplication.class, args);
	}

}
