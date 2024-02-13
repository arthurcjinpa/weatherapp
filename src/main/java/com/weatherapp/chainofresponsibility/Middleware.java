package com.weatherapp.chainofresponsibility;

import com.weatherapp.model.weather.WeatherDataObject;

public abstract class Middleware {
    private Middleware next;

    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract WeatherDataObject getData(String lat, String lon, String cityName);

    protected WeatherDataObject checkNext(String lat, String lon, String cityName) {
        return next.getData(lat, lon, cityName);
    }
}
