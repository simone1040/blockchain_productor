package com.simone.progetto;

import com.simone.progetto.bean.RabbitMQConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("queue")
public class Queue implements Communicator{
	private final RabbitTemplate rabbitTemplate;
	private static final Logger log = LoggerFactory.getLogger(Queue.class);

	@Autowired
	public Queue(final RabbitTemplate template) {
		this.rabbitTemplate = template;
	}

	public boolean sendMessage(Transaction transaction) {
		boolean toRet = false;
		try{
			rabbitTemplate.convertAndSend(RabbitMQConfiguration.EXCHANGE_NAME,
					RabbitMQConfiguration.ROUTING_KEY,
					transaction);
			toRet = true;
		}
		catch (Exception e){
			log.error("Exception --> " + e);
		}
		return toRet;
	}
}
