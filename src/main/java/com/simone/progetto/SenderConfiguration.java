package com.simone.progetto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class SenderConfiguration {
    public static String IP_ADDRESS_SERVER_RABBIT;
    public static final String CONFIGURATION_PATH = "sender.conf";

    public static void Startup(){
        Properties configFile = new Properties();
        try{
            InputStream file = new ClassPathResource(CONFIGURATION_PATH).getInputStream();
            configFile.load(file);
            SenderConfiguration.IP_ADDRESS_SERVER_RABBIT = configFile.getProperty("IP_ADDRESS").trim();
        }
        catch (Exception ex){
            log.info("Exception in read configuration --> " + ex.toString());
            System.exit(1);
        }
    }
}
