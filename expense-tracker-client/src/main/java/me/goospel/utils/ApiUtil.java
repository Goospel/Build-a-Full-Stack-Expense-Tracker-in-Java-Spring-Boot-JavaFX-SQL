package me.goospel.utils;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ApiUtil {
    private static final String SPRINGBOOT_URL = "http://localhost:8080";
    public enum RequestMethod{POST, GET, PUT, DELETE}

    public static HttpURLConnection fetchApi(String apiPath, RequestMethod requestMethod, JsonObject jsonData) {
        try {
            URL url = new URL(SPRINGBOOT_URL + apiPath);
            System.out.println(url.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(requestMethod.toString());

            // to send data to api
            if (jsonData != null && requestMethod != RequestMethod.GET) {
                connection.setRequestProperty("Content-Type", "application/json, charset=utf-8");

                // expects the response body to be a json type
                connection.setRequestProperty("Accept", "application/json");

                // allow us to send data to the connected api
                connection.setDoOutput(true);

                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonData.toString().getBytes(StandardCharsets.UTF_8);

                    os.write(input, 0, input.length);
                }
            }

            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  null;
    }
}
