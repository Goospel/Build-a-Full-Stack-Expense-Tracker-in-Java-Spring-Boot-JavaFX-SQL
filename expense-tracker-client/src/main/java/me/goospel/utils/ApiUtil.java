package me.goospel.utils;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiUtil {
    private static final String SPRINGBOOT_URL = "https://localhost:8080";
    public enum RequestMethod{POST, GET, PUT, DELETE}

    public static HttpURLConnection fetchApi(String apiPath, RequestMethod requestMethod, JsonObject jsonObject) {
        try {
            URL url = new URL(SPRINGBOOT_URL + apiPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(requestMethod.toString());

            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  null;
    }
}
