package com.company;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        WeatherAPI getResponseFromAPI = new WeatherAPI();
        double temp;
//        getResponseFromAPI.getWeatherForecastResponse(); - TBD Forecast
//        getResponseFromAPI.getCurrentWeatherResponse(); - string
        try {
            JSONObject currentMinskState = new JSONObject(getResponseFromAPI.getCurrentWeatherResponse());
            WeatherStateParser stateParser = new WeatherStateParser();
            temp = stateParser.getCurrentTemp(currentMinskState);
            System.out.println("Сейчас " + temp + " градусов по Цельсию");
        } catch (JSONException exception) {
            System.out.println("Invalid JSON");
            System.exit(1);
        }

//        System.out.println("Сейчас " + (currentMinskState.getJSONObject("main").getDouble("temp")-273.15) + " градусов тепла по Цельсию");
    }
}