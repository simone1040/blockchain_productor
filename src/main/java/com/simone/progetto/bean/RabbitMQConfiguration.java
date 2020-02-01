package com.simone.progetto.bean;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    private static final String FANOUT_EXCHANGE = "FanoutExchange";
    public static final String TRANSACTION_QUEUE = "default_transaction_q";

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding TransactionBinding(FanoutExchange fanout, Queue TransactionQueue) {
        return BindingBuilder.bind(TransactionQueue).to(fanout);
    }


    @Bean
    public Queue TransactionQueue() {
        return new Queue(TRANSACTION_QUEUE);
    }

}
