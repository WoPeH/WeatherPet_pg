package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherForecastParser {
    JSONArray forecastList = new JSONArray();
    private JSONArray forecastList1;

    protected void setForecastList(JSONObject forecastJSON) throws JSONException {
        forecastList = forecastJSON.getJSONArray("list");
        System.out.println(forecastList.toString());
    }

    public String getForecastList() {
        return forecastList.toString();
    }



}
