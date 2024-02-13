package com.weatherapp.pattern;

import com.weatherapp.model.geocoder.GeocoderObject;
import com.weatherapp.service.GeocoderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GeocoderMiddleware extends Middleware {

    private final GeocoderService geocoderService;

    @Override
    public boolean getData(String lat, String lon, String cityName) {
        try {
            GeocoderObject geocoderData = geocoderService.getGeocoderData(cityName);
            return checkNext(geocoderData.getLat(), geocoderData.getLon(), cityName);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
