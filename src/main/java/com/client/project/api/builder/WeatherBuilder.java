package com.client.project.api.builder;

import com.client.project.api.model.WeatherWrapperModel;
import com.fasterxml.jackson.core.JsonProcessingException;

import static com.qa.utils.api.RestAssuredUtils.serializeToJson;

public class WeatherBuilder {

    public static String getJsonPayload(WeatherWrapperModel weatherModel) throws JsonProcessingException {
        return serializeToJson(weatherModel, true);
    }

    public static WeatherWrapperModel getCountryData(String countryName) {

        WeatherWrapperModel weatherModel = new WeatherWrapperModel();
        weatherModel.setName(countryName);
        return weatherModel;
    }
}
