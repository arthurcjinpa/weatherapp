package com.weatherapp.pattern;

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

    public abstract boolean getData(String lat, String lon, String cityName);

    protected boolean checkNext(String lat, String lon, String cityName) {
        if (next == null) {
            return true;
        }
        return next.getData(lat, lon, cityName);
    }
}
