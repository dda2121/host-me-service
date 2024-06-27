package com.di.hostme.service.repository.city;

import static com.di.hostme.service.domain.city.error.CityErrorCode.CITY_DOES_NOT_EXIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.di.hostme.service.domain.city.entity.CityEntity;
import com.di.hostme.service.domain.shared.common.error.BusinessException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class JooqCityRepositoryGetTest extends JooqCityRepositoryTest {

  @Test
  public void thatCityCanBeRetrieved() {
    final UUID cityId = cityIds.getFirst();

    final CityEntity cityEntity = getCity(cityRepository, cityId, countryId);
    assertThat(cityEntity).isNotNull();
    assertThat(cityEntity.id()).isNotNull();
    assertThat(cityEntity.createdAt()).isNotNull();
    assertThat(cityEntity.createdBy()).isNotNull();
    assertThat(cityEntity.updatedAt()).isNotNull();
    assertThat(cityEntity.updatedBy()).isNotNull();
    assertThat(cityEntity.countryId()).isNotNull();
    assertThat(cityEntity.name()).isNotNull();

    assertThat(cityEntity.id()).isEqualTo(cityId);
    assertThat(cityEntity.countryId()).isEqualTo(countryId);
    assertThat(cityEntity.name()).isEqualTo("TEST_NAME_1");
  }

  @Test
  public void thatCityWithNotExistingIdCannotBeRetrieved() {
    final UUID notExistingCityId = UUID.randomUUID();

    final BusinessException exception =
        assertThrows(
            BusinessException.class, () -> getCity(cityRepository, notExistingCityId, countryId));
    assertThat(exception.getBusinessError().errorCode()).isEqualTo(CITY_DOES_NOT_EXIST);
    assertThat(exception.getBusinessError().parameters())
        .containsExactlyInAnyOrder(notExistingCityId.toString(), countryId.toString());
  }

  @Test
  public void thatCityWithNotExistingCountryIdCannotBeRetrieved() {
    final UUID cityId = cityIds.getFirst();
    final UUID notExistingCountryId = UUID.randomUUID();

    final BusinessException exception =
        assertThrows(
            BusinessException.class, () -> getCity(cityRepository, cityId, notExistingCountryId));
    assertThat(exception.getBusinessError().errorCode()).isEqualTo(CITY_DOES_NOT_EXIST);
    assertThat(exception.getBusinessError().parameters())
        .containsExactlyInAnyOrder(cityId.toString(), notExistingCountryId.toString());
  }
}
