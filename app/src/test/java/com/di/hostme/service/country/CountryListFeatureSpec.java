package com.di.hostme.service.country;

import static org.assertj.core.api.Assertions.assertThat;

import com.di.hostme.service.rest.api.dto.country.CountryListResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class CountryListFeatureSpec extends CountryFeatureSpec {

  @Test
  public void thatEmptyCountryListCanBeRetrieved() {
    deletePrerequisites();

    final CountryListResponse listResponse =
        listCountries(HttpStatus.OK, CountryListResponse.class);
    assertThat(listResponse.getCountries()).isEmpty();
  }

  @Test
  public void thatCountryListCanBeRetrieved() {
    final CountryListResponse listResponse =
        listCountries(HttpStatus.OK, CountryListResponse.class);

    assertThat(listResponse.getCountries()).isNotEmpty();
    assertThat(listResponse.getCountries().size()).isEqualTo(3);
  }
}
