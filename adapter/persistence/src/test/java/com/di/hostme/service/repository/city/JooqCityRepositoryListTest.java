package com.di.hostme.service.repository.city;

import static org.assertj.core.api.Assertions.assertThat;

import com.di.hostme.service.domain.city.entity.CityEntity;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class JooqCityRepositoryListTest extends JooqCityRepositoryTest {

  @Test
  public void thatEmptyCityListCanBeRetrieved() {
    deletePrerequisites();

    final List<CityEntity> cityEntityList = listCities(cityRepository, countryId);
    assertThat(cityEntityList).isEmpty();
  }

  @Test
  public void thatCityListCanBeRetrieved() {
    final List<CityEntity> cityEntityList = listCities(cityRepository, countryId);

    assertThat(cityEntityList).isNotEmpty();
    assertThat(cityEntityList.size()).isEqualTo(3);
  }

  @Test
  public void thatEmptyCityListForNonExistingCountryIdCanBeRetrieved() {
    final UUID notExistingCountryId = UUID.randomUUID();

    final List<CityEntity> cityEntityList = listCities(cityRepository, notExistingCountryId);

    assertThat(cityEntityList).isEmpty();
  }
}
