package com.di.hostme.service.domain.city.query;

import java.util.UUID;
import org.immutables.value.Value;

@Value.Immutable
public interface FindCityByIdQuery {

  @Value.Parameter
  UUID id();

  @Value.Parameter
  UUID countryId();
}
