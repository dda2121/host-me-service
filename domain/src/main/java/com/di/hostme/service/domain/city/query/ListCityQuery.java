package com.di.hostme.service.domain.city.query;

import java.util.UUID;
import org.immutables.value.Value;

@Value.Immutable
public interface ListCityQuery {

  @Value.Parameter
  UUID countryId();
}
