package com.disruption.AnyPub4J.API;

import com.disruption.AnyPub4J.AP4J;
import com.disruption.AnyPub4J.API.Core.InstanceConfiguration;
import com.disruption.AnyPub4J.API.Core.InstanceStats;
import com.disruption.AnyPub4J.API.Core.InstanceURLs;
import com.disruption.AnyPub4J.API.util.JSONConverter;
import com.disruption.AnyPub4J.Objects.Account;
import com.disruption.AnyPub4J.Objects.Instance;
import com.fasterxml.jackson.databind.JsonNode;

public class InstanceObjectBuildHelper {
    public Instance buildInstance(AP4J ap4J){
        JsonNode instanceNode = ap4J.getCre().newRequest(RequestType.INSTANCE_DATA, ap4J);
        JSONConverter conv = new JSONConverter();
        return new Instance(
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
                new AccountObjectBuildHelper().createAccount(ap4J, instanceNode),
                conv.jsonNodeToStringArray(instanceNode.get("rules"))
        );
            }
}
