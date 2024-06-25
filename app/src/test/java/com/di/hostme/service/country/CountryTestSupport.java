package com.di.hostme.service.country;

import static com.di.hostme.service.controller.BaseController.COUNTRIES_URI;
import static com.di.hostme.service.controller.BaseController.COUNTRY_URI;

import com.di.hostme.service.BaseTestSupport;
import io.restassured.http.ContentType;
import java.util.UUID;
import org.springframework.http.HttpStatus;

public interface CountryTestSupport extends BaseTestSupport {

  default <T> T getCountry(UUID countryId, HttpStatus status, Class<T> response) {
    return requestSpecification()
        .when()
        .get(COUNTRY_URI, countryId)
        .then()
        .log()
        .all()
        .statusCode(status.value())
        .contentType(ContentType.JSON)
        .extract()
        .body()
        .as(response);
  }

  default <T> T listCountries(HttpStatus status, Class<T> response) {
    return requestSpecification()
        .when()
        .get(COUNTRIES_URI)
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
