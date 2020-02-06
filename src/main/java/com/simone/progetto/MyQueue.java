package com.simone.progetto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("queue")
public class MyQueue implements Communicator{
	private final RabbitTemplate rabbitTemplate;
	private static final Logger log = LoggerFactory.getLogger(MyQueue.class);
	@Autowired TransactionRules transactionRules;
	@Autowired private FanoutExchange fanoutExchange;

	@Autowired
	public MyQueue(final RabbitTemplate template) {
		this.rabbitTemplate = template;
	}

	public boolean sendMessage(Transaction transaction) {
		boolean toRet = false;
		if(transactionRules.canSend(transaction)) {
			try {
				rabbitTemplate.convertAndSend(fanoutExchange.getName(),
						"", transaction);
				toRet = true;
			} catch (Exception e) {
				log.error("Exception --> " + e);
			}
		}
		return toRet;
	}
}
