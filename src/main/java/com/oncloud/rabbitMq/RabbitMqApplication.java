package com.oncloud.rabbitMq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.oncloud.rabbitMq.rabbit.Sender;

@SpringBootApplication
public class RabbitMqApplication implements CommandLineRunner {
	@Autowired
	private Sender sender;
	public static void main(String[] args) {
		SpringApplication.run(RabbitMqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		sender.send();
		sender.send(123);
	}
}
