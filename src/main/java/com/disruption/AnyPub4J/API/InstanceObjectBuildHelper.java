package com.disruption.AnyPub4J.API;

import com.disruption.AnyPub4J.AP4J;
import com.disruption.AnyPub4J.API.Core.InstanceConfiguration;
import com.disruption.AnyPub4J.API.Core.InstanceStats;
import com.disruption.AnyPub4J.API.Core.InstanceURLs;
import com.disruption.AnyPub4J.API.util.JSONConverter;
import com.disruption.AnyPub4J.Objects.Instance;
import com.disruptionsystems.logging.LogLevel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InstanceObjectBuildHelper {
    public Instance buildInstance(AP4J ap4J){
        JsonNode instanceNode = null;
        String json = ap4J.getCre().newRequest(RequestType.INSTANCE_DATA, ap4J);
        try {
            instanceNode = new ObjectMapper().readTree(json);
        } catch (JsonProcessingException e) {
            ap4J.getLogger().printToLog(LogLevel.ERROR, "Could not parse Instance Node. This instance might not be compatible\n" + e.getMessage());
        }
        JSONConverter conv = new JSONConverter();
        return new Instance(
                ap4J,
                instanceNode.get("uri").asText(),
                instanceNode.get("title").asText(),
                instanceNode.get("short_description").asText(),
                instanceNode.get("description").asText(),
                instanceNode.get("email").asText(),
                instanceNode.get("version").asText(),
                new InstanceURLs(instanceNode),
                new InstanceStats(instanceNode),
                instanceNode.get("thumbnail").asText(),
                conv.jsonNodeToStringArray(instanceNode.get("languages")),
                instanceNode.get("registrations").asBoolean(),
                instanceNode.get("approval_required").asBoolean(),
                instanceNode.get("invites_enabled").asBoolean(),
                new InstanceConfiguration(instanceNode),
                new AccountObjectBuildHelper().createAccount(ap4J, json),
                conv.jsonNodeToStringArray(instanceNode.get("rules"))
        );
    }
}
