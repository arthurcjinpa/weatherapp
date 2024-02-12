package com.weatherapp.service;

import com.weatherapp.BaseTest;
import com.weatherapp.model.GeocoderObject;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeocoderServiceTest extends BaseTest {

    @Test
    public void testGetGeocoderData() {
        //given
        String city = "Moscow";
        int limit = 1;
        //when
        GeocoderObject weatherData = geocoderService.getGeocoderData(city, limit);
        //then
        assertEquals("Moscow", weatherData.getName());
    }
}
