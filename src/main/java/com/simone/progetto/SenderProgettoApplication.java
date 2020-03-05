package com.simone.progetto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SenderProgettoApplication {
	private static final Logger log = LoggerFactory.getLogger(SenderProgettoApplication.class);
	@Qualifier("queue")
	@Autowired private Communicator communicator;

	public static void main(String[] args) {


		if (args.length > 0) {
			if (args[0].compareTo("-polling") == 0) {
				SpringApplication.run(SenderProgettoApplication.class, args);
			}
			else if(args[0].compareTo("-single") == 0){
				ApplicationContext applicationContext = SpringApplication.run(SenderProgettoApplication.class, args);
				SingleSender singleSender = applicationContext.getBean(SingleSender.class);
				singleSender.sendTransaction();
				((ConfigurableApplicationContext) applicationContext).close();
			}

		}
		else{
			System.out.println("-polling: send transaction every 3 seconds");
			System.out.println("-single: send single");
		}
	}



	public void start(String[] args){


	}
}
