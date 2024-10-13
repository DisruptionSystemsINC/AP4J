package com.disruption.AnyPub4J.API;

import com.disruption.AnyPub4J.AP4J;
import com.disruption.AnyPub4J.API.Core.AccountConfiguration.AccountFields;
import com.disruption.AnyPub4J.API.util.JSONConverter;
import com.disruption.AnyPub4J.Objects.Account;
import com.disruptionsystems.logging.LogLevel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountObjectBuildHelper {
    public Account createAccount(AP4J ap4J, String json){
        JsonNode accountNode;
        try {
            accountNode = new ObjectMapper().readTree(json).path("contact_account");
        } catch (JsonProcessingException e) {
            ap4J.getLogger().printToLog(LogLevel.ERROR, "Could not read JSON tree. The ActivityPub implementation might not be supported.");
            return null;
        }
        JSONConverter conv = new JSONConverter();
        return new Account(
                ap4J,
                accountNode.get("id") != null ? accountNode.get("id").asText() : "UNSUPPORTED",
                accountNode.get("username") != null ? accountNode.get("username").asText() : "UNSUPPORTED",
                accountNode.get("acct") != null ? accountNode.get("acct").asText() : "UNSUPPORTED",
                accountNode.get("fqn") != null ? accountNode.get("fqn").asText() : "UNSUPPORTED",
                accountNode.get("display_name") != null ? accountNode.get("display_name").asText() : "UNSUPPORTED",
                accountNode.get("locked") != null ? accountNode.get("locked").asBoolean() : null,
                accountNode.get("created_at") != null ? accountNode.get("created_at").asText() : "UNSUPPORTED",
                accountNode.get("followers_count") != null ? accountNode.get("followers_count").asInt() : null,
                accountNode.get("following_count") != null ? accountNode.get("following_count").asInt() : null,
                accountNode.get("statuses_count") != null ? accountNode.get("statuses_count").asInt() : null,
                accountNode.get("note") != null ? accountNode.get("note").asText() : "UNSUPPORTED",
                accountNode.get("url") != null ? accountNode.get("url").asText() : "UNSUPPORTED",
                accountNode.get("uri") != null ? accountNode.get("uri").asText() : "UNSUPPORTED",
                accountNode.get("avatar")  != null ? accountNode.get("avatar").asText() : "UNSUPPORTED",
                accountNode.get("avatar_static")  != null ? accountNode.get("avatar_static").asText() : "UNSUPPORTED",
                accountNode.get("header")  != null ? accountNode.get("header").asText() : "UNSUPPORTED",
                accountNode.get("header_static") != null ? accountNode.get("header_static").asText() : "UNSUPPORTED",
                conv.jsonNodeToStringArray(accountNode.get("emojis")),
                accountNode.get("moved") != null ? accountNode.get("moved").asText() : "UNSUPPORTED",
                new AccountFields(accountNode),
                accountNode.get("bot") != null ? accountNode.get("bot").asBoolean() : null,
                accountNode.get("discoverable") != null ? accountNode.get("discoverable").asBoolean() : null
        );
    }
}
