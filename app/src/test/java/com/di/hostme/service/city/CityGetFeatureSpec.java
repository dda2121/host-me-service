package com.di.hostme.service.city;

import static com.di.hostme.service.domain.city.error.CityErrorCode.CITY_DOES_NOT_EXIST;
import static org.assertj.core.api.Assertions.assertThat;

import com.di.hostme.service.rest.api.dto.city.CityDetailResponse;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponse;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponseFault;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class CityGetFeatureSpec extends CityFeatureSpec {

  @Test
  public void thatCityCanBeRetrieved() {
    final UUID cityId = cityIds.getFirst();

    final CityDetailResponse detailResponse =
        getCity(countryId, cityId, HttpStatus.OK, CityDetailResponse.class);
    assertThat(detailResponse).isNotNull();
    assertThat(detailResponse.getId()).isNotNull();
    assertThat(detailResponse.getCreatedAt()).isNotNull();
    assertThat(detailResponse.getCreatedBy()).isNotNull();
    assertThat(detailResponse.getUpdatedAt()).isNotNull();
    assertThat(detailResponse.getUpdatedBy()).isNotNull();
    assertThat(detailResponse.getCountryId()).isNotNull();
    assertThat(detailResponse.getName()).isNotNull();

    assertThat(detailResponse.getId()).isEqualTo(cityId);
    assertThat(detailResponse.getCountryId()).isEqualTo(countryId);
    assertThat(detailResponse.getName()).isEqualTo("TEST_NAME_1");
  }

  @Test
  public void thatCityWithNotExistingIdCannotBeRetrieved() {
    final UUID notExistingCityId = UUID.randomUUID();

    final ErrorResponseFault errorResponseFault =
        getCity(countryId, notExistingCityId, HttpStatus.NOT_FOUND, ErrorResponse.class)
            .errorResponseFaults()
            .getFirst();
    assertThat(errorResponseFault.code()).isEqualTo(CITY_DOES_NOT_EXIST.toString());
    assertThat(errorResponseFault.message()).isEqualTo(CITY_DOES_NOT_EXIST.template());
    assertThat(errorResponseFault.messageParameters())
        .containsExactlyInAnyOrder(notExistingCityId.toString(), countryId.toString());
  }

  @Test
  public void thatCityWithNotExistingCountryIdCannotBeRetrieved() {
    final UUID cityId = cityIds.getFirst();
    final UUID notExistingCountryId = UUID.randomUUID();

    final ErrorResponseFault errorResponseFault =
        getCity(notExistingCountryId, cityId, HttpStatus.NOT_FOUND, ErrorResponse.class)
            .errorResponseFaults()
            .getFirst();
    assertThat(errorResponseFault.code()).isEqualTo(CITY_DOES_NOT_EXIST.toString());
    assertThat(errorResponseFault.message()).isEqualTo(CITY_DOES_NOT_EXIST.template());
    assertThat(errorResponseFault.messageParameters())
        .containsExactlyInAnyOrder(cityId.toString(), notExistingCountryId.toString());
  }
}
