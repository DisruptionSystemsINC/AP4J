package com.disruption.AnyPub4J.API;

import com.disruption.AnyPub4J.AP4J;
import com.disruptionsystems.logging.LogLevel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Request {
    public String get(String uri, AP4J ap4J) {
        StringBuffer response = new StringBuffer();
        BufferedReader reader;
        JsonNode node = null;
        URL url = null;
        try {
            url = new URI(uri).toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            ap4J.getLogger().printToLog(LogLevel.ERROR, "The given instance_url is invalid. Shutting down.");
            System.exit(1);
        }
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.addRequestProperty("client_name", "AP4J Request Engine");
            con.setRequestMethod("GET");
            if (con.getResponseCode() != 200){
                ap4J.getLogger().printToLog(LogLevel.ERROR, "Error encountered while getting Request. Error code: " + con.getResponseCode() + " : " + con.getResponseMessage());
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
        } catch (IOException e){
            ap4J.getLogger().printToLog(LogLevel.ERROR, "Exception caught while getting Request. Error: " + e.getMessage());
        }

        return response.toString();
    }

    public String postForm(String uri, String[][] dataArray, AP4J ap4J){
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(uri);
        JsonNode node = null;
        String json = null;
        for (String[] data : dataArray) {
            builder.addTextBody(data[0], data[1]);
        }
        HttpEntity ent = builder.build();
        post.setEntity(ent);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(post);
            HttpEntity responseEntity = response.getEntity();
            json = new String(responseEntity.getContent().readAllBytes());
            node = new JsonMapper().readTree(json);
        } catch (IOException e) {
            ap4J.getLogger().printToLog(LogLevel.ERROR, "Exception caught while posting Request. Error: " + e.getMessage());
        }
        return json;
    }

}
