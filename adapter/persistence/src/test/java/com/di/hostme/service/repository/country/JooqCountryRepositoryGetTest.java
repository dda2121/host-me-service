package com.di.hostme.service.repository.country;

import static com.di.hostme.service.domain.country.error.CountryErrorCode.COUNTRY_DOES_NOT_EXIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.di.hostme.service.domain.country.entity.CountryEntity;
import com.di.hostme.service.domain.shared.common.error.BusinessException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class JooqCountryRepositoryGetTest extends JooqCountryRepositoryTest {

  @Test
  public void thatCountryCanBeRetrieved() {
    final UUID countryId = countryIds.getFirst();

    final CountryEntity countryEntity = getCountry(countryRepository, countryId);
    assertThat(countryEntity).isNotNull();
    assertThat(countryEntity.id()).isNotNull();
    assertThat(countryEntity.createdAt()).isNotNull();
    assertThat(countryEntity.createdBy()).isNotNull();
    assertThat(countryEntity.updatedAt()).isNotNull();
    assertThat(countryEntity.updatedBy()).isNotNull();
    assertThat(countryEntity.name()).isNotNull();

    assertThat(countryEntity.id()).isEqualTo(countryId);
    assertThat(countryEntity.name()).isEqualTo("TEST_NAME_1");
  }

  @Test
  public void thatCountryWithNotExistingIdCannotBeRetrieved() {
    final UUID notExistingCountryId = UUID.randomUUID();

    final BusinessException exception =
        assertThrows(
            BusinessException.class, () -> getCountry(countryRepository, notExistingCountryId));
    assertThat(exception.getBusinessError().errorCode()).isEqualTo(COUNTRY_DOES_NOT_EXIST);
    assertThat(exception.getBusinessError().parameters().getFirst())
        .isEqualTo(notExistingCountryId.toString());
  }
}
