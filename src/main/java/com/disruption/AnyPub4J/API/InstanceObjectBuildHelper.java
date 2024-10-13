package com.disruption.AnyPub4J.API;

import com.disruption.AnyPub4J.AP4J;
import com.disruption.AnyPub4J.Objects.Instance;
import com.fasterxml.jackson.databind.JsonNode;

public class InstanceObjectBuildHelper {
    public Instance buildInstance(AP4J ap4J){
        JsonNode instanceNode = ap4J.getCre().newRequest(RequestType.INSTANCE_DATA, ap4J);
        return new Instance(

        );
            }
}
