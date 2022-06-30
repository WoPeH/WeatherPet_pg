package com.company;
import org.json.*;

public class WeatherStateParser {
    public double getCurrentTemp(JSONObject weatherResponse) throws JSONException{
        return weatherResponse.getJSONObject("main").getDouble("temp")-273.15;
    }
}
