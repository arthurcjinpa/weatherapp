package com.weatherapp.chainofresponsibility;

import com.weatherapp.exception.WeatherDataException;
import com.weatherapp.model.weather.WeatherDataObject;
import com.weatherapp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@RequiredArgsConstructor
@Component
public class WeatherMiddleware extends Middleware {
    private static final Logger LOGGER = Logger.getLogger(WeatherService.class.getName());

    private final WeatherService weatherService;

    @Override
    public WeatherDataObject getData(String lat, String lon, String cityName) {
        try {
            WeatherDataObject weatherDataObject = weatherService.getWeatherDataObject(lat, lon);
            LOGGER.info(String.format("Temp in %s is %s celsius", cityName, weatherDataObject.getMain().getTemp()));
            return weatherDataObject;
        } catch (Exception ex) {
            throw new WeatherDataException("The website is down or received incorrect data from geocoder, please try again.");
        }
    }
}
