package com.disruption.AnyPub4J;

import com.disruption.AnyPub4J.API.AP4JBuilder;
import com.disruption.AnyPub4J.API.Request;
import com.disruptionsystems.DragonLog;

import java.net.URI;
import java.net.URL;

public class HTTPTests {
    public static void main(String[] args) {
        AP4J bot = new AP4JBuilder().setEndpoint("https://derg.social/api/v1/").build();
        System.out.println(bot.getHomeInstance());
    }
}
