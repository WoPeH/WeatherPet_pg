package com.company;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        WeatherAPI getResponseFromAPI = new WeatherAPI();
        double temp;
        String weatherDescription;
//        getResponseFromAPI.getWeatherForecastResponse(); - TBD Forecast
//        getResponseFromAPI.getCurrentWeatherResponse(); - string
        try {
            JSONObject currentMinskStateJSON = new JSONObject(getResponseFromAPI.getCurrentWeatherResponse());
            WeatherStateParser stateParser = new WeatherStateParser();
            temp = stateParser.getCurrentTemp(currentMinskStateJSON);
            System.out.println("Сейчас " + temp + " градусов по Цельсию");
            weatherDescription = stateParser.getCurrentWeatherDescription(currentMinskStateJSON);
            System.out.println("Погода сейчас:\n" + weatherDescription);
        } catch (JSONException exception) {
            System.out.println("Invalid JSON");
            System.exit(1);
        }

//        System.out.println("Сейчас " + (currentMinskState.getJSONObject("main").getDouble("temp")-273.15) + " градусов тепла по Цельсию");
    }
}