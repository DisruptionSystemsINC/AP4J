package com.disruption.AnyPub4J;

import com.disruption.AnyPub4J.API.ChorusRequestEngine;
import com.disruption.AnyPub4J.API.Core.Token;
import com.disruption.AnyPub4J.API.EventListener;
import com.disruption.AnyPub4J.API.InstanceObjectBuildHelper;
import com.disruption.AnyPub4J.API.RequestType;
import com.disruption.AnyPub4J.Objects.Instance;
import com.disruptionsystems.DragonLog;

public class AP4J {
    private String APIEndpoint;
    private Instance homeInstance;
    private ChorusRequestEngine cre;
    private DragonLog logger;
    private String name;
    private String website;
    private String[] scopes;
    private Token token;
    private EventListener[] eventListeners;

    public AP4J(DragonLog logger, String APIEndpoint, String name, EventListener[] eventListeners, String website, String[] scopes) {
        if (logger == null) {
            this.logger = new DragonLog();
        } else {
            this.logger = logger;
        }
        this.name = name;
        this.cre = new ChorusRequestEngine();
        this.APIEndpoint = APIEndpoint;
        this.eventListeners = eventListeners;
        this.token = this.cre.newRequest(RequestType.TOKEN_REFRESH, this);
        this.homeInstance = new InstanceObjectBuildHelper().buildInstance(this);
    }

    public DragonLog getLogger() {
        return this.logger;
    }

    public ChorusRequestEngine getCre() {
        return this.cre;
    }

    public String getAPIEndpoint() {
        return this.APIEndpoint;
    }

    public String getName(){
        return this.name;
    }

    public String getWebsite(){
        return this.website;
    }

    public String[] getScopes() {
        return this.scopes;
    }

    public Instance getHomeInstance(){
        return homeInstance;
    }
}
