package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

class Main {
    public static void main(String[] args) throws IOException {
        WeatherAPI getResponseFromAPI = new WeatherAPI(); //Initialize API to perform requests and get response as string
        double temp; //temperature variable
        double tempFeelsLike; //temperature like it feels
        int currentHumidity;
        String weatherDescription; //string for weather description
        try { //try-catch to throw exception in case json is invalid
            JSONObject currentMinskStateJSON = new JSONObject(getResponseFromAPI.getCurrentWeatherResponse()); //Initialize JSONObject to store response
            WeatherStateParser stateParser = new WeatherStateParser(); //Initialize Parser to get values from response
            temp = stateParser.getCurrentTemp(currentMinskStateJSON); //get current temperature from JSON
            System.out.println("\nСейчас " + Math.round(temp) + "° Цельсия"); //output current temperature
            tempFeelsLike = stateParser.getCurrentFeelsLikeTemp(currentMinskStateJSON); //get Feels like temperature from JSON
            System.out.println("Ощущается как " + Math.round(tempFeelsLike) + "° Цельсия"); //output feels like temperature
            currentHumidity = stateParser.getCurrentHumidity(currentMinskStateJSON); //get current humidity
            System.out.println("Влажность: " + currentHumidity + "%"); //output current humidity
            weatherDescription = stateParser.getCurrentWeatherDescription(currentMinskStateJSON); //get weather description from JSON, map it to local naming
            System.out.println("\nПогода сейчас:\n" + weatherDescription); //output weather description

            JSONObject weatherForecastJSON = new JSONObject(getResponseFromAPI.getWeatherForecastResponse()); //Initialize JSONObject to store response
            System.out.println("log: GET forecastJSON");
            WeatherForecastParser forecastParser = new WeatherForecastParser(); // new parser to get values from forecast response(?)
            System.out.println("log: initialize forecastParser");
            forecastParser.setForecastList(weatherForecastJSON); //extract array of weather to Forecast parser
            System.out.println("set Parser with arrayList from response");
            JSONArray forecastList = new JSONArray(forecastParser.getForecastList()); //get array of weather to Main (?)
            System.out.println("Get arraylist to main");
            long daySlicer = 0; //variable to add 1 day when day != day of Forecast[i] not to spam full date
            for (int i = 0; i<39; i++){
               LocalDate forecastDate = Instant.ofEpochMilli(forecastList.getJSONObject(i).getLong("dt")*1000).atZone(ZoneId.systemDefault()).toLocalDate(); //set forecast date by unix timestamp from response
               LocalTime hours = Instant.ofEpochMilli(forecastList.getJSONObject(i).getLong("dt")*1000).atZone(ZoneId.systemDefault()).toLocalTime(); //set time from unix timestamp from response to output hours
               LocalDate nowDate = LocalDate.now(); //current date

               if (forecastDate.getDayOfMonth() != (nowDate.plusDays(daySlicer)).getDayOfMonth()){ //each new day output day number, increment daySlicer
                   System.out.println("День месяца: " + forecastDate.getDayOfMonth() + "\nВремя:  " + + hours.getHour());
                   daySlicer++;
               }
               else{
                   System.out.println("Время: " + hours.getHour());
               }
               System.out.println("В это время будет " + Math.round(stateParser.getCurrentTemp(forecastList.getJSONObject(i)))+ "° Цельсия"); //output forecast temperature
               System.out.println("Погода в это время:\n" + stateParser.getCurrentWeatherDescription(forecastList.getJSONObject(i))); //output forecast weather description
               System.out.println();
            }
        } catch (JSONException exception) {
            System.out.println("Invalid JSON");
            System.exit(1);
        }
    }
}