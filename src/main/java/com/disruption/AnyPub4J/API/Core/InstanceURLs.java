package com.disruption.AnyPub4J.API.Core;

import com.disruption.AnyPub4J.API.util.JSONConverter;
import com.fasterxml.jackson.databind.JsonNode;

public class InstanceURLs {
    JsonNode node;
    public InstanceURLs(JsonNode node){
        this.node = node;
    }

    public String[][] getAll(){
        JSONConverter conv = new JSONConverter();
        JsonNode urlnode = node.path("urls");
        String[] descs = conv.jsonNodeToStringArray(urlnode);
        String[] values = new String[ urlnode.size()];
        for (int i = 0; i < urlnode.size(); i++){
            values[i] = urlnode.get(i).asText();
        }
        return new String[][]{descs, values};
    }
}
