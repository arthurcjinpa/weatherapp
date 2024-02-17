package com.weatherapp.kafka;

import com.weatherapp.model.weather.WeatherDataObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class KafkaSender {

    private final KafkaTemplate<String, WeatherDataObject> kafkaTemplate;

    public void sendMessage(WeatherDataObject message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }
}
