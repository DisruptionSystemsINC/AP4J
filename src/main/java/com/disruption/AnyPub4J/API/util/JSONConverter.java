package com.disruption.AnyPub4J.API.util;

import com.fasterxml.jackson.databind.JsonNode;

public class JSONConverter {
    public String[] jsonNodeToStringArray(JsonNode node){
        String[] arr = new String[node.size()];
        for (int i = 0; i < node.size(); i++){
            arr[i] = node.get(i).asText();
        }
        return arr;
    }
}
