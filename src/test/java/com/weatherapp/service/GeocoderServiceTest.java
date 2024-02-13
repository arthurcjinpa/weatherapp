package com.weatherapp.service;

import com.weatherapp.BaseTest;
import com.weatherapp.model.geocoder.GeocoderObject;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeocoderServiceTest extends BaseTest {

    @Test
    public void testGetGeocoderData() {
        //given
        String city = "Moscow";
        //when
        GeocoderObject geocoderData = geocoderService.getGeocoderData(city);
        //then
        assertEquals("Moscow", geocoderData.getName());
    }
}
