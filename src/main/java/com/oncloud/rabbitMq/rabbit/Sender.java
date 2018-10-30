package com.oncloud.rabbitMq.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	@Autowired
	private AmqpTemplate template;
	/*
	 * direct 类型交换器  通过默认的exchange，routing_keying 就是queue_name:"hello"
	 */
	public void send() {
		template.convertAndSend("hello","hello message");
	}
	/*
	 * direct 类型交换器  通过directExchange routing_key 就是“user”
	 */
	public void send(int time) {
		template.convertAndSend("directExchange","user",time);
	}
}
