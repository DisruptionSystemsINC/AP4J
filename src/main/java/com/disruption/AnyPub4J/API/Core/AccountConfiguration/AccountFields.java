package com.disruption.AnyPub4J.API.Core.AccountConfiguration;

import com.disruption.AnyPub4J.AP4J;
import com.fasterxml.jackson.databind.JsonNode;

public class AccountFields {
    private JsonNode node;
    public AccountFields(JsonNode node){
        this.node = node;
    }

    public String[][] getAll(){
         String[] fields = jsonNodeToStringArray(node.get("fields"));
    }


    private String[] jsonNodeToStringArray(JsonNode node){
        String[] arr = new String[node.size()];
        for (int i = 0; i < node.size(); i++){
            arr[i] = node.get(i).asText();
        }
        return arr;
    }
}
