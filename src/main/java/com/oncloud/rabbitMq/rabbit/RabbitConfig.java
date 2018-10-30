package com.oncloud.rabbitMq.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Bean
	public Queue helloQueue() {
		return new Queue("hello");//注册一个目的地址为hello的监听器
	}
	
	@Bean
	public Queue junQueue() {
		return new Queue("jun");
	}
	
	@Bean
	public Queue queueMessage() {
		return new Queue("topicMessage_queue");
	}
	@Bean
	public Queue queueMessages() {
		return new Queue("topicMessages_queue");
	}
	@Bean
	public Queue AMessage() {
		return new Queue("fanoutA_queue");
	
	}
	@Bean
	public Queue BMessage() {
		return new Queue("fanoutB_queue");
	}
	@Bean
	public Queue CMessage() {
	return new Queue("fanoutC_queue");
	}
	
	
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("directExchange");
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("topicExchange");
	}
	
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanoutExchange");
	}
	//helloQueue()是绑定到一个默认的空白字符串的交换器上了   路邮键就是列队名
	//将junQueue()与DirectExchange()通过user进行绑定  路邮键是"user"
	@Bean
	public Binding bindingDirectExchange() {
		return BindingBuilder.bind(junQueue()).to(directExchange()).with("user");
	}
	
	//将列队与topicMessage()进行绑定   路邮键是“topic.message”
	@Bean
	public Binding bindingTopicExchange() {
		return BindingBuilder.bind(queueMessage()).to(topicExchange()).with("topic.message");
	}
	//此处是路由键进行模糊匹配
	@Bean
	public Binding bindingTopicExchanges() {
		return BindingBuilder.bind(queueMessage()).to(topicExchange()).with("topic.#");
	}
	@Bean
	public Binding bindingFanoutExchangeA() {
		return BindingBuilder.bind(AMessage()).to(fanoutExchange());
	}
	@Bean
	public Binding bindingFanoutExchangeB() {
		return BindingBuilder.bind(BMessage()).to(fanoutExchange());
	}
	@Bean
	public Binding bindingFanoutExchangeC() {
		return BindingBuilder.bind(CMessage()).to(fanoutExchange());
	}
}

