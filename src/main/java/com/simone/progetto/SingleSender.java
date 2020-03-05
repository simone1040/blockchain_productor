package com.simone.progetto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingleSender {
    @Autowired private Communicator communicator;
    private static final Logger log = LoggerFactory.getLogger(PollingSender.class);

    public void sendTransaction(){
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
