package com.di.hostme.service.domain.shared.common.entity;

import java.time.OffsetDateTime;
import java.util.UUID;
import org.immutables.value.Value;

@Value.Immutable
public interface AuditableEntity {

  OffsetDateTime createdAt();

  UUID createdBy();

  OffsetDateTime updatedAt();

  UUID updatedBy();
}
