package com.disruption.AnyPub4J;

import com.disruption.AnyPub4J.Objects.Instance;
import com.disruptionsystems.DragonLog;

public class AP4J {
    private static String APIEndpoint;
    private static Instance homeInstance;
    private static DragonLog logger;
    private static String client_id;
    private static String client_secret;

    public AP4J(){

    }


    public static AP4J build(){
        logger = new DragonLog();

        return new AP4J();
    }

    public static DragonLog getLogger() {return logger;}

    public static void setLogger(DragonLog logger1) {logger = logger1;}

    public static String getAPIEndpoint() {return APIEndpoint;}

    public static void setAPIEndpoint(String APIEndpoint) {AP4J.APIEndpoint = APIEndpoint;}
}
