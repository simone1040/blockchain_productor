package com.simone.progetto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service("local_queue")
public class LocalQueue implements Communicator {
    @Autowired
    private Queue queue;
    @Autowired
    TransactionRules transactionRules;
    private static final Logger log = LoggerFactory.getLogger(LocalQueue.class);

    @Override
    public boolean sendMessage(Transaction transaction) {
        boolean toRet = false;
        if(transactionRules.canSend(transaction)){
            toRet = queue.sendMessage(transaction);
        }
        if(toRet){
            log.info("Transaction send correctly");
        }
        else{
            log.info("Transaction blocked");
        }
        return toRet;
    }
}
