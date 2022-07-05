package com.company;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherStateParser {
    public double getCurrentTemp(JSONObject weatherResponse) throws JSONException {
        return weatherResponse.getJSONObject("main").getDouble("temp") - 273.15; //function returns current temperature as double
    }

    public double getCurrentFeelsLikeTemp(JSONObject weatherResponse) throws JSONException {
        return weatherResponse.getJSONObject("main").getDouble("feels_like") - 273.15; //function returns temperature as it feels like as double
    }

    // TBD round.math here?

    public String getCurrentWeatherDescription(JSONObject weatherResponse) throws JSONException {
        return WeatherDescriptionMapper.descriptionMapper(weatherResponse.getJSONArray("weather").getJSONObject(0).getInt("id")); //maps weather id to normal description and returns as String
    }

    public int getCurrentHumidity(JSONObject weatherResponse) throws JSONException {
        return weatherResponse.getJSONObject("main").getInt("humidity"); //get humidity in percent
    }
}
