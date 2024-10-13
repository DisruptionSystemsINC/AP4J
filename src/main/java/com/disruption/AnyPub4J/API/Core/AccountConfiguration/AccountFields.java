package com.disruption.AnyPub4J.API.Core.AccountConfiguration;

import com.disruption.AnyPub4J.API.util.JSONConverter;
import com.fasterxml.jackson.databind.JsonNode;

public class AccountFields {
    private JsonNode node;
    public AccountFields(JsonNode node){
        this.node = node;
    }

    public String[] getAll(){
        JSONConverter conv = new JSONConverter();
         return conv.jsonNodeToStringArray(node.path("fields"));
    }
}
