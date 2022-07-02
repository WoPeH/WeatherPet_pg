package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


final class WeatherAPI {
    final double latitudeMinsk = 53.893009;
    final double longitudeMinsk = 27.567444;
    String forecastURLString = "https://api.openweathermap.org/data/2.5/forecast?lat=" + latitudeMinsk + "&lon=" + longitudeMinsk + "&appid=" + System.getenv("APIKey");
    String weatherURLString = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitudeMinsk + "&lon=" + longitudeMinsk + "&appid=" + System.getenv("APIKey"); //trash "&dt="+ Long.toString(unixTime) +
    String responseChecker;

    protected String getCurrentWeatherResponse() throws IOException {
        StringBuffer responseBuffer = new StringBuffer();
        // long unixTime = System.currentTimeMillis() / 1000L;
        URL weatherURI = new URL(weatherURLString);
        HttpURLConnection connectionToWeatherAPI = (HttpURLConnection) weatherURI.openConnection();
        connectionToWeatherAPI.setConnectTimeout(5000);
        connectionToWeatherAPI.setReadTimeout(10000);
        int APIResponseStatus = connectionToWeatherAPI.getResponseCode();
        System.out.println("Response status " + APIResponseStatus);
        BufferedReader responseReader = new BufferedReader(new InputStreamReader(connectionToWeatherAPI.getInputStream()));
        while ((responseChecker = responseReader.readLine()) != null) {
            responseBuffer.append(responseChecker);
        }
        connectionToWeatherAPI.disconnect();
        System.out.println(responseBuffer);
        return responseBuffer.toString();
    }

    protected String getWeatherForecastResponse() throws IOException {
        StringBuffer responseBuffer = new StringBuffer();
        URL forecastURI = new URL(forecastURLString);
        HttpURLConnection connectionToForecastAPI = (HttpURLConnection) forecastURI.openConnection();
        connectionToForecastAPI.setConnectTimeout(5000);
        connectionToForecastAPI.setReadTimeout(10000);
        int APIResponseStatus = connectionToForecastAPI.getResponseCode();
        System.out.println("Response status " + APIResponseStatus);
        BufferedReader responseReader = new BufferedReader(new InputStreamReader(connectionToForecastAPI.getInputStream()));
        while ((responseChecker = responseReader.readLine()) != null) {
            responseBuffer.append(responseChecker);
        }
        connectionToForecastAPI.disconnect();
        System.out.println(responseBuffer);
        return responseBuffer.toString();
    }
}
