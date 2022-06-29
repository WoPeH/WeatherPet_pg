package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

final class WeatherAPI {
    protected void getCurrentTemperature(String APIKey) throws IOException {
       // long unixTime = System.currentTimeMillis() / 1000L;
        final double latitudeMinsk = 53.893009;
        final double longitudeMinsk = 27.567444;
        String temperatureURL = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitudeMinsk + "&lon=" + longitudeMinsk + "&appid=" + APIKey; //trash "&dt="+ Long.toString(unixTime) +
        URL temperatureURI = new URL(temperatureURL);
        HttpURLConnection connectionToAPI = (HttpURLConnection) temperatureURI.openConnection();
        connectionToAPI.setConnectTimeout(5000);
        connectionToAPI.setReadTimeout(10000);
        int APIResponseStatus = connectionToAPI.getResponseCode();
        System.out.println("Response status " + APIResponseStatus);
        BufferedReader responseReader = new BufferedReader(new InputStreamReader(connectionToAPI.getInputStream()));
        String responseText;
        StringBuffer responseBuffer = new StringBuffer();
        while ((responseText = responseReader.readLine()) != null){
            responseBuffer.append(responseText);
        }
        connectionToAPI.disconnect();
        System.out.println(responseBuffer);
    }
}
