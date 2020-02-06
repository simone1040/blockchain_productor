package com.simone.progetto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SenderProgettoApplication {
	private static final Logger log = LoggerFactory.getLogger(SenderProgettoApplication.class);
	@Qualifier("queue")
	@Autowired private Communicator communicator;

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SenderProgettoApplication.class, args);
		SenderProgettoApplication senderProgettoApplication = applicationContext.getBean(SenderProgettoApplication.class);
		senderProgettoApplication.start(args);
		((ConfigurableApplicationContext) applicationContext).close();
	}



	public void start(String[] args){
		Product product = new Product("Pasta",0.5);
		Transaction transaction = new Transaction(1,product,2);

		Product product1 = new Product("",0.5);
		Transaction transaction1 = new Transaction(1,product1,2);
		if(communicator.sendMessage(transaction)){
			log.info("Transaction send!");
		}
		else{
			log.info("Transaction blocked!");
		}
		if(communicator.sendMessage(transaction1)){
			log.info("Transaction send!");
		}
		else{
			log.info("Transaction blocked!");
		}

	}
}
