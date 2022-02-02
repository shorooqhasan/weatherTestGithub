package com.client.project.api.payload;

import com.client.project.api.builder.WeatherBuilder;
import com.client.project.api.model.WeatherWrapperModel;
import com.fasterxml.jackson.core.JsonProcessingException;

import static com.client.project.api.builder.WeatherBuilder.getCountryData;

public class WeatherPayload {

    public static String buildGetCountryDataPayload(String countryName)
            throws JsonProcessingException {
        WeatherWrapperModel weatherModel = getCountryData(countryName);
        return WeatherBuilder.getJsonPayload(weatherModel);
    }
}
