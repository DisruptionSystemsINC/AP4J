package com.disruption.AnyPub4J.API;

import com.disruption.AnyPub4J.AP4J;
import com.disruptionsystems.DragonLog;
import jdk.jfr.Description;

public class AP4JBuilder {
    private EventListener[] eventListeners;
    private DragonLog logger;
    private String endpoint;

    public AP4J build(){
        if (logger==null){
            logger = new DragonLog();
        }
        return new AP4J(logger, endpoint, eventListeners);
    }

    public AP4JBuilder addEventListeners(EventListener... eventListeners){
        this.eventListeners = eventListeners;
        return this;
    }

    public AP4JBuilder setDragonLogger(DragonLog logger){
        this.logger = logger;
        return this;
    }

    /**
     * @param endpoint
     * The instance you want the bot to operate on (https://example.com/api/v1/)
     */
    public AP4JBuilder setEndpoint(String endpoint){
        this.endpoint = endpoint;
        return this;
    }
}