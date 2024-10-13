package com.disruption.AnyPub4J.API;

import com.disruption.AnyPub4J.AP4J;
import com.disruption.AnyPub4J.API.Core.AccountConfiguration.AccountFields;
import com.disruption.AnyPub4J.API.util.JSONConverter;
import com.disruption.AnyPub4J.Objects.Account;
import com.fasterxml.jackson.databind.JsonNode;

public class AccountObjectBuildHelper {
    public Account createAccount(AP4J ap4J, JsonNode instanceNode){
        JsonNode accountNode = instanceNode.path("contact_account");
        JSONConverter conv = new JSONConverter();
        return new Account(
                accountNode.get("id").asText(),
                accountNode.get("username").asText(),
                accountNode.get("acct").asText(),
                accountNode.get("fqn").asText(),
                accountNode.get("display_name").asText(),
                accountNode.get("locked").asBoolean(),
                accountNode.get("created_at").asText(),
                accountNode.get("followers_count").asInt(),
                accountNode.get("following_count").asInt(),
                accountNode.get("statuses_count").asInt(),
                accountNode.get("note").asText(),
                accountNode.get("url").asText(),
                accountNode.get("uri").asText(),
                accountNode.get("avatar").asText(),
                accountNode.get("avatar_static").asText(),
                accountNode.get("header").asText(),
                accountNode.get("header_static").asText(),
                conv.jsonNodeToStringArray(accountNode.get("emojis")),
                accountNode.get("moved").asText(),
                new AccountFields(accountNode),
                accountNode.get("bot").asBoolean(),
                accountNode.get("discoverable").asBoolean()
        );
    }
}
