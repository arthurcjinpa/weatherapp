package com.weatherapp.exception;

public class GeocoderException extends RuntimeException {
    public GeocoderException(String message) {
        super(message);
    }
}
