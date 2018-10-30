package com.oncloud.rabbitMq.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component

public class Receiver {
	@RabbitListener(queues = "hello")
	@RabbitHandler
	public void process(String text) {
		System.out.println(text);
	}
	
	@RabbitListener(queues = "jun")
	@RabbitHandler
	public void process2(String text) {
		System.out.println(text);
	}
}
