package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

class Main {
    public static void main(String[] args) throws IOException {
        WeatherAPI getResponseFromAPI = new WeatherAPI(); //Initialize API to perform requests and get response as string
        double temp; //temperature variable
        double tempFeelsLike; //temperature like it feels
        int currentHumidity;
        String weatherDescription; //string for weather description
 //- TBD Forecast
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

            JSONObject weatherForecastJSON = new JSONObject(getResponseFromAPI.getWeatherForecastResponse());
            System.out.println("log: GET forecastJSON");
            WeatherForecastParser forecastParser = new WeatherForecastParser();
            System.out.println("log: initialize forecastParser");
            forecastParser.setForecastList(weatherForecastJSON);
            System.out.println("set Parser with arrayList from response");
            JSONArray forecastList = new JSONArray(forecastParser.getForecastList());
            System.out.println("Get arraylist to main");
            Date outputDateTime = new Date();
            System.out.println("Initialize date");
            long daySlicer = 0;
            for (int i = 0; i<39; i++){
               outputDateTime.setTime(forecastList.getJSONObject(i).getLong("dt")*1000);
               LocalDate ld = Instant.ofEpochMilli(forecastList.getJSONObject(i).getLong("dt")*1000).atZone(ZoneId.systemDefault()).toLocalDate();
               LocalTime hours = Instant.ofEpochMilli(forecastList.getJSONObject(i).getLong("dt")*1000).atZone(ZoneId.systemDefault()).toLocalTime();
               LocalDate nowDate = LocalDate.now();

               if (ld.getDayOfMonth() != (nowDate.plusDays(daySlicer)).getDayOfMonth()){
                   System.out.println("День месяца: " + ld.getDayOfMonth() + "\nВремя:  " + + hours.getHour());
                   daySlicer++;
               }
               else{
                   System.out.println("Время: " + hours.getHour());
               }
               System.out.println("В это время будет " + Math.round(stateParser.getCurrentTemp(forecastList.getJSONObject(i)))+ "° Цельсия");
               System.out.println("Погода в это время:\n" + stateParser.getCurrentWeatherDescription(forecastList.getJSONObject(i)));
               System.out.println();
            }
        } catch (JSONException exception) {
            System.out.println("Invalid JSON");
            System.exit(1);
        }
    }
}