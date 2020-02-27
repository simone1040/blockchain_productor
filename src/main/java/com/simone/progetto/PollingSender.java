package com.simone.progetto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PollingSender {
    @Autowired private Communicator communicator;
    private static final Logger log = LoggerFactory.getLogger(SenderProgettoApplication.class);

    @Scheduled(fixedDelay = 3000, initialDelay = 500)
    public void send() {
        Product product = new Product("Pasta",0.5);
        Transaction transaction = new Transaction(1,product,2);
        if(communicator.sendMessage(transaction)){
            log.info("Transaction send!");
        }
        else{
            log.info("Transaction blocked!");
        }
    }
}
