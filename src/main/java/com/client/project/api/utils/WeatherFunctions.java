package com.client.project.api.utils;

import com.client.project.api.model.WeatherWrapperModel;
import io.restassured.response.Response;

import static com.qa.utils.api.RestAssuredUtils.convertRawToJson;
import static com.qa.utils.common.Logger.logInfo;
import static org.testng.Assert.assertNotEquals;

public class WeatherFunctions {
    public static Integer getCityId(Response rawRes) {

        Integer cityId = convertRawToJson(rawRes).get("id");

        logInfo(String.format("city Id is:", cityId));
        return cityId;
    }
    public static void verifyCityIdNotNull(Response rawRes) {
        Integer cityId = getCityId(rawRes);
        assertNotEquals(cityId, "", String.format("Invalid feature flow id", cityId));

        logInfo(String.format(" City data retrieved successfully : %s", cityId));
    }
    public static String getCountryValue(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        String countryName= wrapperModel.getSys().getCountry();
        logInfo("Country NAme-->>" + countryName);
        return countryName;
    }

    public  static Float getTempValue(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        logInfo("Wrapper class-- >" + wrapperModel);
        Float temperature = wrapperModel.getMain().getTemp();
        return temperature;
    }

    public static String getCityNameValue(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        logInfo("Wrapper class-- >" + wrapperModel);
        String cityName = wrapperModel.getName();
        return cityName;
    }
    public static Float longitudeValue(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        Float longitude = wrapperModel.getCoord().getLon();
        return longitude;
    }

    public static Float latitudeValue(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        Float latitude = wrapperModel.getCoord().getLat();
        return latitude;
    }

    public static Integer getSunRise(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        Integer sunRise = wrapperModel.getSys().getSunrise();
        return sunRise;
    }
    public static Integer getSunSet(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        Integer sunSet = wrapperModel.getSys().getSunset();
        return sunSet;
    }

    public static Float getWindSpeed(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        Float windSpeed = wrapperModel.getWind().getSpeed();
        return windSpeed;
    }

    public static Integer getHumidity(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        Integer humidity = wrapperModel.getMain().getHumidity();
        return humidity;
    }

    public static Integer getCloudsAll(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        Integer all = wrapperModel.getClouds().getAll();
        return all;
    }
    public static Float getTempMin(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        Float tempMin = wrapperModel.getMain().getTemp_min();
        return tempMin;
    }
    public static Float getTempMax(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        Float tempMax = wrapperModel.getMain().getTemp_max();
        return tempMax;
    }
    public static Float getPressure(Response rawRes) {
        WeatherWrapperModel wrapperModel = rawRes.getBody().as(WeatherWrapperModel.class);
        Float tempMax = wrapperModel.getMain().getPressure();
        return tempMax;
    }

}

