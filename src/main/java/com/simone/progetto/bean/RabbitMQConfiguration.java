package com.simone.progetto.bean;

import com.simone.progetto.SenderConfiguration;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    private static final String FANOUT_EXCHANGE = "FanoutExchange";
    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(SenderConfiguration.IP_ADDRESS_SERVER_RABBIT);
        return connectionFactory;
    }
}
