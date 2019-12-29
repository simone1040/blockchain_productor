package com.simone.progetto;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SenderProgettoApplication {
	public static void main(String[] args) {
		Product product = new Product("Pasta",0.5);
		Transaction transaction = new Transaction(1,product,2);
		ApplicationContext applicationContext = SpringApplication.run(SenderProgettoApplication.class, args);
		Queue queue = (Queue) applicationContext.getBean(Queue.class);
		queue.sendMessage(transaction);
		((ConfigurableApplicationContext) applicationContext).close();
	}
}
