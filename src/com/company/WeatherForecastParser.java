package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherForecastParser {
    JSONArray forecastList = new JSONArray();

    protected void setForecastList(JSONObject forecastJSON) throws JSONException { // function sets Parser field JSONArray to list of weather forecast (also JSONArray)
        forecastList = forecastJSON.getJSONArray("list");
        System.out.println(forecastList.toString());
    }

    public String getForecastList() {
        return forecastList.toString();
    } //simple getter to return forecast list



}
