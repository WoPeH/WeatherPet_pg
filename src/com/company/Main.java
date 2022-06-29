package com.company;


import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        final String APIKey = "fad6b233e633306f19594a521300981f";
        WeatherAPI getResponseFromAPI= new WeatherAPI();
        getResponseFromAPI.getCurrentTemperature(APIKey);
    }
}