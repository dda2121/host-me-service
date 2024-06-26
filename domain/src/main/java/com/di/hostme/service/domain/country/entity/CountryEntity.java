package com.di.hostme.service.domain.country.entity;

import com.di.hostme.service.domain.shared.common.entity.AuditableEntity;
import java.util.UUID;
import org.immutables.value.Value;

@Value.Immutable
public sealed interface CountryEntity extends AuditableEntity permits ImmutableCountryEntity {

  UUID id();

  String name();
}
