package com.company;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        WeatherAPI getResponseFromAPI = new WeatherAPI(); //Initialize API to perform requests and get response as string
        double temp; //temperature variable
        double tempFeelsLike; //temperature like it feels
        int currentHumidity;
        String weatherDescription; //string for weather description
        getResponseFromAPI.getWeatherForecastResponse(); //- TBD Forecast
//        getResponseFromAPI.getCurrentWeatherResponse(); - string
        try { //try-catch to throw exception in case json is invalid
            JSONObject currentMinskStateJSON = new JSONObject(getResponseFromAPI.getCurrentWeatherResponse()); //Initialize JSONObject to store response
            WeatherStateParser stateParser = new WeatherStateParser(); //Initialize Parser to get values from response
            temp = stateParser.getCurrentTemp(currentMinskStateJSON); //get current temperature from JSON
            System.out.println("\nСейчас " + Math.round(temp) + "° Цельсия"); //output current temperature
            tempFeelsLike = stateParser.getCurrentFeelsLikeTemp(currentMinskStateJSON);
            System.out.println("Ощущается как " + Math.round(tempFeelsLike) + "° Цельсия");
            currentHumidity = stateParser.getCurrentHumidity(currentMinskStateJSON);
            System.out.println("Влажность: " + currentHumidity + "%");
            weatherDescription = stateParser.getCurrentWeatherDescription(currentMinskStateJSON); //get weather description from JSON, map it to local naming
            System.out.println("\nПогода сейчас:\n" + weatherDescription); //output weather description
        } catch (JSONException exception) {
            System.out.println("Invalid JSON");
            System.exit(1);
        }
    }
}