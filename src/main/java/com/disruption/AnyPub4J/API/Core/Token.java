package com.disruption.AnyPub4J.API.Core;

public class Token {
    public String clientSecret;
    public String clientID;

    public Token(String clientID, String clientSecret) {
        this.clientID = clientID;
        this.clientSecret = clientSecret;
    }

    public String getClientSecret(){
        return clientSecret;
    }

    public String getClientID(){
        return clientID;
    }
}
