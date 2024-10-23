package com.disruption.AnyPub4J.API;

import com.disruption.AnyPub4J.AP4J;
import com.disruption.AnyPub4J.API.Core.Token;

public class ChorusRequestEngine {
    public Token newRequest(RequestType type, AP4J ap4J){
        switch(type){
            case TOKEN_REFRESH -> {
                return new Request().postForm(ap4J.getAPIEndpoint() + "apps", new String[][]{{"client_name", ap4J.getName()}, {"redirect_uris", "urn:ietf:wg:oauth:2.0:oob"}, {"scopes", "read write push"}, {"website", "https://disruption-systems.com"}}, ap4J);
            }
        }
        return null;
    }
    public String getHomeInstance(RequestType type, AP4J ap4J) {
        return new Request().get(ap4J.getAPIEndpoint() + "instance", ap4J);
    }

    public String getInstanceByEndpoint(RequestType type, AP4J ap4J, String baseUrl){
            return new Request().get(baseUrl + "instance", ap4J);
    }
}
