package com.di.hostme.service.domain.country.query;

import java.util.UUID;
import org.immutables.value.Value;

@Value.Immutable
public interface FindCountryByIdQuery {

  @Value.Parameter
  UUID id();
}
