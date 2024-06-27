package com.di.hostme.service.repository.city;

import static org.assertj.core.api.Assertions.assertThat;

import com.di.hostme.service.domain.city.entity.CityEntity;
import java.util.List;
import org.junit.jupiter.api.Test;

public class JooqCityRepositoryListTest extends JooqCityRepositoryTest {

  @Test
  public void thatEmptyCityListCanBeRetrieved() {
    deletePrerequisites();

    final List<CityEntity> cityEntityList = listCities(cityRepository);
    assertThat(cityEntityList).isEmpty();
  }

  @Test
  public void thatCountryListCanBeRetrieved() {
    final List<CityEntity> cityEntityList = listCities(cityRepository);

    assertThat(cityEntityList).isNotEmpty();
    assertThat(cityEntityList.size()).isEqualTo(3);
  }
}
