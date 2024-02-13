package com.weatherapp.pattern;

import com.weatherapp.model.geocoder.GeocoderObject;
import com.weatherapp.model.weather.WeatherDataObject;
import com.weatherapp.service.GeocoderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@RequiredArgsConstructor
@Component
public class GeocoderMiddleware extends Middleware {
    private static final Logger LOGGER = Logger.getLogger(GeocoderService.class.getName());

    private final GeocoderService geocoderService;

    @Override
    public WeatherDataObject getData(String lat, String lon, String cityName) {
        try {
            GeocoderObject geocoderData = geocoderService.getGeocoderData(cityName);
            LOGGER.info(String.format("Geocoder successfully returned %s lat and %s lon", lat, lon));
            return checkNext(geocoderData.getLat(), geocoderData.getLon(), cityName);
        } catch (Exception ex) {
            LOGGER.severe("Could not find the city, there may be a mistake in the name.");
            return null;
        }
    }
}
