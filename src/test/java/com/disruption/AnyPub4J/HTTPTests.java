package com.disruption.AnyPub4J;

import com.disruption.AnyPub4J.API.Request;
import com.disruptionsystems.DragonLog;

import java.net.URI;
import java.net.URL;

public class HTTPTests {
    public static void main(String[] args) {
        AP4J.setLogger(new DragonLog());
        Request.postForm("https://derg.social/api/v1/apps", new String[][]{{"client_name", "AP4J CHORUS REQUEST ENGINE"}, {"redirect_uris", "urn:ietf:wg:oauth:2.0:oob"}, {"scopes", "read write push"}, {"website", "https://disruption-systems.com"}});
    }
}
