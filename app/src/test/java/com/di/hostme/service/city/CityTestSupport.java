package com.di.hostme.service.city;

import static com.di.hostme.service.controller.CityController.CITIES_URI;
import static com.di.hostme.service.controller.CityController.CITY_URI;

import com.di.hostme.service.BaseTestSupport;
import io.restassured.http.ContentType;
import java.util.UUID;
import org.springframework.http.HttpStatus;

public interface CityTestSupport extends BaseTestSupport {

  default <T> T getCity(UUID countryId, UUID cityId, HttpStatus status, Class<T> response) {
    return requestSpecification()
        .when()
        .get(CITY_URI, countryId, cityId)
        .then()
        .log()
        .all()
        .statusCode(status.value())
        .contentType(ContentType.JSON)
        .extract()
        .body()
        .as(response);
  }

  default <T> T listCities(UUID countryId, HttpStatus status, Class<T> response) {
    return requestSpecification()
        .when()
        .get(CITIES_URI, countryId)
        .then()
        .log()
        .all()
        .statusCode(status.value())
        .contentType(ContentType.JSON)
        .extract()
        .body()
        .as(response);
  }
}
