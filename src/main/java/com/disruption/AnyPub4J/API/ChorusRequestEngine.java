package com.disruption.AnyPub4J.API;

import com.fasterxml.jackson.databind.JsonNode;

import java.net.http.HttpRequest;

public class ChorusRequestEngine {
    public JsonNode newRequest(RequestType type){
        switch(type){
            case TOKEN_REFRESH -> {
                Request.postForm("/api/v1/apps", new String[][]{{"client_name", "AP4J CHORUS REQUEST ENGINE"}, {"redirect_uris", "urn:ietf:wg:oauth:2.0:oob"}, {"scopes", "read write push"}, {"website", "https://disruption-systems.com"}})
            }
        }
    }
}
