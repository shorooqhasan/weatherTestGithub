package com.client.project.api.request;

import com.client.project.api.resource.WeatherResource;
import io.restassured.response.Response;
import ru.yandex.qatools.allure.annotations.Step;

import static com.client.project.common.ConfigFileReaderUtils.getValueFromEnvironmentFile;
import static com.qa.utils.common.Logger.logResponse;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class WeatherRequest {


    @Step("Get Country by Country Name ")
    public static Response getCountryDetails(String countryName) {

       final String host = getValueFromEnvironmentFile("host_api");

        //final String resourcePath = "q=" + countryName + "&appid=" + WeatherResource.appId;

        //logInfo("Base URL : " + host);
       // logInfo("Path : " + resourcePath);
      // logInfo("Full URL is:" + host + resourcePath );
       // String host = "https://api.openweathermap.org/data/2.5/weather?";
       // String resourcePath =" q=Berlin&appid=8c3a4b459a022385b02c843fea558c4d";

        Response rawRes =
                given()
                        .with()
                        .queryParam("q", countryName)
                        .queryParam("appid",WeatherResource.appId)
                        .queryParam("units","metric")
                        .when()
                        .baseUri(host)
                        .get(host)
                        .then()
                        .statusCode(200)
                        .contentType(JSON)
                        .extract()
                        .response();
        logResponse(rawRes);
        return rawRes;
    }
}
