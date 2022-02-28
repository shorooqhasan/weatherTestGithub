package com.client.project.api.tests.featureflow;

import com.client.project.api.request.WeatherRequest;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.io.IOException;

import static com.client.project.api.utils.WeatherCalculationsAnalysis.*;
import static com.client.project.api.utils.WeatherFunctions.*;
import static com.qa.utils.api.RestAssuredUtils.verifyStatusCode;
import static com.qa.utils.common.Logger.logInfo;
import static org.testng.Assert.assertEquals;

public class WeatherTest {

    @BeforeClass
    @Description("Verify Weather Details Retrieval - City ID is not NULL")
    public void testGetWeatherByCityName() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Berlin");
        verifyStatusCode(rawRes, 200);
        verifyCityIdNotNull(rawRes);
        logInfo("Details retrieved");
    }
    @Test
    @Description("Verify Weather Details Retrieval - Country value is correct")
    public void verifyCountryValue() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Berlin");
        verifyStatusCode(rawRes, 200);
        String countryName = getCountryValue(rawRes);
        logInfo("country name->>> "+countryName);
        assertEquals(countryName,"DE","Germany is the correct country");
    }

    @Test
    @Description("Verify Weather Details Retrieval -  City name is correct")
    public void verifyCityNameValue() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Berlin");
        verifyStatusCode(rawRes, 200);
        String cityName = getCityNameValue(rawRes);
        assertEquals(cityName,"Berlin","Germany is the correct country");
    }

    @Test
    @Description("Verify Weather Details Retrieval -  Correct Coordinates are retrieved ")
    public void verifyCoordsValue() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Cairo");
        verifyStatusCode(rawRes, 200);
        Float lon = longitudeValue(rawRes);
        Float lat =  latitudeValue(rawRes);
        assertEquals(lat.toString(),"30.0626","Wrong latitude");
        assertEquals(lon.toString(),"31.2497","Wrong longitude");

    }

    @Test
    @Description("Verify Weather Details Retrieval - Verify Sunrise time is not after sunset time ")
    public void verifySunsetIsNotBeforeSunRise() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Berlin");
        verifyStatusCode(rawRes, 200);
        Integer sunRise = getSunRise(rawRes);
        Integer sunSet = getSunSet(rawRes);
        String result =  verifyValueXnotExceedingValueY(sunSet,sunRise);
        assertEquals(result, "Test is passed","Sunrise time cannot be after sunset time");

    }
    @Test
    @Description("Verify Weather Details Retrieval - Wind Speed cannot be negative ")
    public void verifyWindSpeedIsNotNegative() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Berlin");
        verifyStatusCode(rawRes, 200);
        Float windSpeed = getWindSpeed(rawRes);
        String result = verifyValueIsNotNegative(windSpeed);
        assertEquals(result,"positive","Value cannot be negative");
    }
    @Test
    @Description("Verify Weather Details Retrieval - Temperature cannot be negative ")
    public void verifyTempIsNotNegative() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Berlin");
        verifyStatusCode(rawRes, 200);
        Float tempValue = getTempValue(rawRes);
        String result = verifyValueIsNotNegative(tempValue);
        assertEquals(result,"positive","Value cannot be negative");
    }

    @Test
    @Description("Verify Weather Details Retrieval - Humidity cannot be negative ")
    public void verifyHumidityIsNotNegativeValue() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Cairo");
        verifyStatusCode(rawRes, 200);
        Integer humidity = getHumidity(rawRes);
        String result = verifyValueIsNotNegative(humidity);
        logInfo("Humidity is -> " + result);
        assertEquals(result,"positive","Value cannot be negative");
    }

    @Test
    @Description("Verify Weather Details Retrieval - Humidity is percentage")
    public void verifyHumidityIsPercentage() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Cairo");
        verifyStatusCode(rawRes, 200);
        Integer humidity = getHumidity(rawRes);
        Boolean result = evaluateValueIsPercentage(humidity.floatValue());
        assertEquals(result.toString(),"true","Value should be percentage");
    }
    @Test
    @Description("Verify Weather Details Retrieval -  verify sunrise is during AM period")
    public void verifySunriseIsDuringPM() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Cairo");
        verifyStatusCode(rawRes, 200);
        Integer sunRise = getSunRise(rawRes);
        String date =  getDateAndTime2(sunRise);
        String time = getTime(date);
        String rise = verifySunRiseTime(time);
        assertEquals(rise,"true","sunrise is not during AM period");
    }

    @Test
    @Description("Verify Weather Details Retrieval - verify sunset is during PM period")
    public void verifySunSetIsDuringPM() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Cairo");
        verifyStatusCode(rawRes, 200);
        Integer sunSet = getSunSet(rawRes);
        String date =  getDateAndTime2(sunSet);
        String time = getTime(date);
        String rise = verifySunSetTime(time);
        assertEquals(rise,"true","sunset should during PM period");
    }

    @Test
    @Description("Verify Weather Details Retrieval - Sunset and Sunrise time is for today date ")
    public void verifyReturnedTimeStampIsToday() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Athens");
        verifyStatusCode(rawRes, 200);
        Integer sunSet = getSunSet(rawRes);
        String dateOfSunSet = getDate(sunSet);
        Integer sunRise = getSunRise(rawRes);
        String dateOfSunRise = getDate(sunRise);
        assertEquals(dateOfSunSet,getTodayDate(),"");
        assertEquals(dateOfSunRise,getTodayDate(),"");
    }
    @Test
    @Description("Verify Weather Details Retrieval - Clouds-all should be percentage ")
    public void verifyCloudsAllIsPercentage() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Cairo");
        verifyStatusCode(rawRes, 200);
        Integer clouds = getCloudsAll(rawRes);
        Boolean result = evaluateValueIsPercentage(clouds.floatValue());
        assertEquals(result.toString(),"true","Value should be percentage");
    }

    @Test
    @Description("Verify Weather Details Retrieval - Maximum Temp shouldn't be more than 50")
    public void verifyMaxTempValueIsLessThanMaximum() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Cairo");
        verifyStatusCode(rawRes, 200);
        Float maxTemp = getTempMax(rawRes);
        String  result = getMaxTempValueIsLessThanTheMaximum(maxTemp);
        assertEquals(result,"true","Value shouldn't be more than 50");
    }
    @Test
    @Description("Verify Weather Details Retrieval - Minimum Temp shouldn't be less than - 50")
    public void verifyMinTempValueIsGreaterThanMinimum() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Cairo");
        verifyStatusCode(rawRes, 200);
        Float minTemp = getTempMin(rawRes);
        String  result = getMinTempValueIsGreaterThanTheMinimum(minTemp);
        assertEquals(result,"true","Minimum Temp shouldn't be less than -50");
    }

    @Test
    @Description("Verify Weather Details Retrieval - Pressure value cannot be negative ")
    public void verifyPressureIsNotNegative() throws IOException {
        Response rawRes = WeatherRequest.getCountryDetails("Cairo");
        verifyStatusCode(rawRes, 200);
        Float pressure = getPressure(rawRes);
        String result = verifyValueIsNotNegative(pressure);
        assertEquals(result,"positive","Pressure value cannot be negative");
    }
}