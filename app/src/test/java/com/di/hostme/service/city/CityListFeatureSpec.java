package com.di.hostme.service.city;

import static org.assertj.core.api.Assertions.assertThat;

import com.di.hostme.service.rest.api.dto.city.CityListResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class CityListFeatureSpec extends CityFeatureSpec {

  @Test
  public void thatEmptyCityListCanBeRetrieved() {
    deletePrerequisites();

    final CityListResponse listResponse =
        listCities(countryId, HttpStatus.OK, CityListResponse.class);
    assertThat(listResponse.getCities()).isEmpty();
  }

  @Test
  public void thatCityListCanBeRetrieved() {
    final CityListResponse listResponse =
        listCities(countryId, HttpStatus.OK, CityListResponse.class);

    assertThat(listResponse.getCities()).isNotEmpty();
    assertThat(listResponse.getCities().size()).isEqualTo(3);
  }
}
