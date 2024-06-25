package com.di.hostme.service.repository.country;

import static org.assertj.core.api.Assertions.assertThat;

import com.di.hostme.service.domain.country.entity.CountryEntity;
import java.util.List;
import org.junit.jupiter.api.Test;

public class JooqCountryRepositoryListTest extends JooqCountryRepositoryTest {

  @Test
  public void thatEmptyCountryListCanBeRetrieved() {
    deletePrerequisites();

    final List<CountryEntity> countryEntityList = listCountries(countryRepository);
    assertThat(countryEntityList).isEmpty();
  }

  @Test
  public void thatCountryListCanBeRetrieved() {
    final List<CountryEntity> countryEntityList = listCountries(countryRepository);

    assertThat(countryEntityList).isNotEmpty();
    assertThat(countryEntityList.size()).isEqualTo(3);
  }
}
