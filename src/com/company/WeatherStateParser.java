package com.company;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherStateParser {
    public double getCurrentTemp(JSONObject weatherResponse) throws JSONException {
        return weatherResponse.getJSONObject("main").getDouble("temp") - 273.15;
    }

    public double getCurrentFeelsLikeTemp(JSONObject weatherResponse) throws JSONException {
        return weatherResponse.getJSONObject("main").getDouble("feels_like") - 273.15;
    }

    public String getCurrentWeatherDescription(JSONObject weatherResponse) throws JSONException {
        return WeatherDescriptionMapper.descriptionMapper(weatherResponse.getJSONArray("weather").getJSONObject(0).getInt("id"));
    }
}
