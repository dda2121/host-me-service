package com.di.hostme.service.repository.country;

import com.di.hostme.service.domain.country.entity.CountryEntity;
import com.di.hostme.service.domain.country.query.ImmutableFindCountryByIdQuery;
import java.util.List;
import java.util.UUID;

public interface JooqCountryRepositoryTestSupport {

  default CountryEntity getCountry(JooqCountryRepository repository, UUID id) {
    return repository.findOne(ImmutableFindCountryByIdQuery.of(id));
  }

  default List<CountryEntity> listCountries(JooqCountryRepository repository) {
    return repository.list();
  }
}
