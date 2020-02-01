package com.simone.progetto;


import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SenderProgettoApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SenderProgettoApplication.class, args);
		SenderProgettoApplication senderProgettoApplication = applicationContext.getBean(SenderProgettoApplication.class);
		senderProgettoApplication.start(args);
		((ConfigurableApplicationContext) applicationContext).close();
	}

	@Qualifier("local_queue")
	@Autowired private Communicator communicator;

	public void start(String[] args){
		Product product = new Product("Pasta",0.5);
		Transaction transaction = new Transaction(1,product,2);

		Product product1 = new Product("",0.5);
		Transaction transaction1 = new Transaction(1,product1,2);

		communicator.sendMessage(transaction);
		communicator.sendMessage(transaction1);
	}
}
