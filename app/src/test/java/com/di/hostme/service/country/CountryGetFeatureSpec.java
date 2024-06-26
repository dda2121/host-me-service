package com.di.hostme.service.country;

import static com.di.hostme.service.domain.country.error.CountryErrorCode.COUNTRY_DOES_NOT_EXIST;
import static org.assertj.core.api.Assertions.assertThat;

import com.di.hostme.service.rest.api.dto.common.error.ErrorResponse;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponseFault;
import com.di.hostme.service.rest.api.dto.country.CountryDetailResponse;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class CountryGetFeatureSpec extends CountryFeatureSpec {

  @Test
  public void thatCountryCanBeRetrieved() {
    final UUID countryId = countryIds.getFirst();

    final CountryDetailResponse detailResponse =
        getCountry(countryId, HttpStatus.OK, CountryDetailResponse.class);
    assertThat(detailResponse).isNotNull();
    assertThat(detailResponse.getId()).isNotNull();
    assertThat(detailResponse.getCreatedAt()).isNotNull();
    assertThat(detailResponse.getCreatedBy()).isNotNull();
    assertThat(detailResponse.getUpdatedAt()).isNotNull();
    assertThat(detailResponse.getUpdatedBy()).isNotNull();
    assertThat(detailResponse.getName()).isNotNull();

    assertThat(detailResponse.getId()).isEqualTo(countryId);
    assertThat(detailResponse.getName()).isEqualTo("TEST_NAME_1");
  }

  @Test
  public void thatCountryWithNotExistingIdCannotBeRetrieved() {
    final UUID notExistingCountryId = UUID.randomUUID();

    final ErrorResponseFault errorResponseFault =
        getCountry(notExistingCountryId, HttpStatus.NOT_FOUND, ErrorResponse.class)
            .errorResponseFaults()
            .getFirst();
    assertThat(errorResponseFault.code()).isEqualTo(COUNTRY_DOES_NOT_EXIST.toString());
    assertThat(errorResponseFault.message()).isEqualTo(COUNTRY_DOES_NOT_EXIST.template());
    assertThat(errorResponseFault.messageParameters())
        .isEqualTo(List.of(notExistingCountryId.toString()));
  }
}
