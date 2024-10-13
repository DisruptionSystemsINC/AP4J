package com.disruption.AnyPub4J.API.Core;

import com.fasterxml.jackson.databind.JsonNode;

public class InstanceStats {
    JsonNode node;
    public InstanceStats(JsonNode node){
        this.node = node;
    }

    public int getUserCount(){
        return node.path("stats").get("user_count").asInt();
    }

    public int getStatusCount(){
        return node.path("stats").get("status_count").asInt();
    }

    public int getDomainCount(){
        return node.path("stats").get("domain_count").asInt();
    }
}
