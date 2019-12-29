package com.simone.progetto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Sender {
	private final RabbitTemplate rabbitTemplate;
	private static final Logger log = LoggerFactory.getLogger(Sender.class);
	
	public Sender(final RabbitTemplate template) {
		this.rabbitTemplate = template;
	}
	
	@Scheduled(fixedDelay = 3000L)
	public void sendMessage() {
		Product product = new Product("Pasta",0.5);
		Transaction transaction = new Transaction(1,product,2,"1111");
		rabbitTemplate.convertAndSend(SenderProgettoApplication.EXCHANGE_NAME,
				SenderProgettoApplication.ROUTING_KEY,
				transaction);
		log.info("message sent");
	}

}
