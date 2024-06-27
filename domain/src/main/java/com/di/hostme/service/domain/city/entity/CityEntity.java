package com.di.hostme.service.domain.city.entity;

import com.di.hostme.service.domain.shared.common.entity.AuditableEntity;
import java.util.UUID;
import org.immutables.value.Value;

@Value.Immutable
public sealed interface CityEntity extends AuditableEntity permits ImmutableCityEntity {

  UUID id();

  UUID countryId();

  String name();
}
