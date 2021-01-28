package com.simone.progetto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SingleSender {
    @Autowired private Communicator communicator;

    public void sendTransaction(){
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
