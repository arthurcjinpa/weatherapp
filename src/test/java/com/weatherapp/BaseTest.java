package com.weatherapp;

import com.weatherapp.service.GeocoderService;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class BaseTest {
    @Autowired protected GeocoderService geocoderService;
}
