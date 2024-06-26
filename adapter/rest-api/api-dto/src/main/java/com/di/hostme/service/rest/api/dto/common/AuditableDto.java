package com.di.hostme.service.rest.api.dto.common;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.immutables.value.Value;

@JsonSerialize(as = ImmutableAuditableDto.class)
@JsonDeserialize(as = ImmutableAuditableDto.class)
@Value.Immutable
public interface AuditableDto {

  @NotNull
  @PastOrPresent
  @Schema(
      description = "The timestamp when the entity was created",
      requiredMode = REQUIRED,
      example = "2024-06-25T14:45:30.123+02:00")
  OffsetDateTime getCreatedAt();

  @NotNull
  @Schema(
      description = "The unique identifier of the user who created the entity",
      requiredMode = REQUIRED,
      example = "e9ee4c87-8633-4393-b6a6-1b7778585d51")
  UUID getCreatedBy();

  @NotNull
  @PastOrPresent
  @Schema(
      description = "The timestamp when the entity was last updated",
      requiredMode = REQUIRED,
      example = "2024-06-25T14:45:30.123+02:00")
  OffsetDateTime getUpdatedAt();

  @NotNull
  @Schema(
      description = "The unique identifier of the user who last updated the entity",
      requiredMode = REQUIRED,
      example = "e9ee4c87-8633-4393-b6a6-1b7778585d51")
  UUID getUpdatedBy();
}
