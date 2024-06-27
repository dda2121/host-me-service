package com.di.hostme.service.repository.city;

import com.di.hostme.service.domain.city.entity.CityEntity;
import com.di.hostme.service.domain.city.query.ImmutableFindCityByIdQuery;
import java.util.List;
import java.util.UUID;

public interface JooqCityRepositoryTestSupport {

  default CityEntity getCity(JooqCityRepository repository, UUID id, UUID countryId) {
    return repository.findOne(ImmutableFindCityByIdQuery.of(id, countryId));
  }

  default List<CityEntity> listCities(JooqCityRepository repository) {
    return repository.list();
  }
}
