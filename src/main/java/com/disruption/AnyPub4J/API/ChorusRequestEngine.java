package com.disruption.AnyPub4J.API;

import com.disruption.AnyPub4J.AP4J;
import com.fasterxml.jackson.databind.JsonNode;

import java.net.http.HttpRequest;

public class ChorusRequestEngine {
    public JsonNode newRequest(RequestType type, AP4J ap4J){
        switch(type){
            case TOKEN_REFRESH -> {
                new Request().postForm(ap4J.getAPIEndpoint() + "apps", new String[][]{{"client_name", "AP4J CHORUS REQUEST ENGINE"}, {"redirect_uris", "urn:ietf:wg:oauth:2.0:oob"}, {"scopes", "read write push"}, {"website", "https://disruption-systems.com"}}, ap4J);
            }
            case INSTANCE_DATA -> {
                return new Request().get(ap4J.getAPIEndpoint() + "instance", ap4J);
            }
        }
        return null;
    }

    public JsonNode newRequest(RequestType type, AP4J ap4J, String baseUrl){
        switch(type){
            case TOKEN_REFRESH -> {
                new Request().postForm(ap4J.getAPIEndpoint() + "apps", new String[][]{{"client_name", "AP4J CHORUS REQUEST ENGINE"}, {"redirect_uris", "urn:ietf:wg:oauth:2.0:oob"}, {"scopes", "read write push"}, {"website", "https://disruption-systems.com"}}, ap4J);
            }
            case INSTANCE_DATA -> {
                return new Request().get(baseUrl + "instance", ap4J);
            }
        }
        return null;
    }
}
