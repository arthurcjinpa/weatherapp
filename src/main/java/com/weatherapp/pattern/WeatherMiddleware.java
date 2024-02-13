package com.weatherapp.pattern;

import com.weatherapp.model.weather.WeatherDataObject;
import com.weatherapp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WeatherMiddleware extends Middleware {

    private final WeatherService weatherService;

    @Override
    public boolean getData(String lat, String lon, String cityName) {
        try {
            WeatherDataObject weatherDataObject = weatherService.getWeatherDataObject(lat, lon);
            System.out.printf("Temp in %s is %s celsius", cityName, weatherDataObject.getMain().getTemp());
            return checkNext(lat, lon, cityName);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
