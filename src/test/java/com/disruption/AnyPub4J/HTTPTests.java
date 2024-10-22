package com.disruption.AnyPub4J;

import com.disruption.AnyPub4J.API.AP4JBuilder;

import java.util.Arrays;

public class HTTPTests {
    public static void main(String[] args) {
        AP4J bot = new AP4JBuilder().setEndpoint("https://mastodon.social/api/v1/").build();
        System.out.println(Arrays.stream(bot.getHomeInstance().getRules()).toList());
    }
}
