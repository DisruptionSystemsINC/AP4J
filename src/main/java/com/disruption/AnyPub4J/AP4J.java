package com.disruption.AnyPub4J;

import com.disruption.AnyPub4J.API.ChorusRequestEngine;
import com.disruption.AnyPub4J.API.EventListener;
import com.disruption.AnyPub4J.API.InstanceObjectBuildHelper;
import com.disruption.AnyPub4J.Objects.Instance;
import com.disruptionsystems.DragonLog;

public class AP4J {
    private String APIEndpoint;
    private Instance homeInstance;
    private ChorusRequestEngine cre;
    private DragonLog logger;
    private String client_id;
    private String client_secret;
    private EventListener[] eventListeners;

    public AP4J(DragonLog logger, String APIEndpoint, EventListener[] eventListeners) {
        if (logger == null) {
            this.logger = new DragonLog();
        } else {
            this.logger = logger;
        }
        this.cre = new ChorusRequestEngine();
        this.homeInstance = new InstanceObjectBuildHelper().buildInstance(this);
        this.APIEndpoint = APIEndpoint;
        this.eventListeners = eventListeners;
    }

    public DragonLog getLogger() {
        return this.logger;
    }

    public ChorusRequestEngine getCre() {
        return this.cre;
    }

    public String getAPIEndpoint() {
        return APIEndpoint;
    }

    protected void setClientID(String id){
        this.client_id = id;
    }

    protected void setClientSecret(String secret){
        this.client_secret = secret;
    }

    public Instance getHomeInstance(){
        return homeInstance;
    }
}
