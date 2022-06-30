package com.company;
import java.io.IOException;

import org.json.*;

class Main {
    public static void main(String[] args) throws IOException {

        WeatherAPI getResponseFromAPI = new WeatherAPI();
//        getResponseFromAPI.getWeatherForecastResponse();
        //getResponseFromAPI.getCurrentWeatherResponse(); - string
        JSONObject currentMinskState = new JSONObject(getResponseFromAPI.getCurrentWeatherResponse());
        System.out.println("Сейчас " + (currentMinskState.getJSONObject("main").getDouble("temp")-273.15) + " градусов тепла по Цельсию");
    }
}