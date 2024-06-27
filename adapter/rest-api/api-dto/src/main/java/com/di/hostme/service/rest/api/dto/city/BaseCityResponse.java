package com.di.hostme.service.rest.api.dto.city;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import com.di.hostme.service.rest.api.dto.common.AuditableDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import org.immutables.value.Value;

@JsonSerialize(as = ImmutableBaseCityResponse.class)
@JsonDeserialize(as = ImmutableBaseCityResponse.class)
@Value.Immutable
public interface BaseCityResponse extends AuditableDto {

  @NotNull
  @Schema(
      description = "The unique identifier of the city",
      requiredMode = REQUIRED,
      example = "e9ee4c87-8633-4393-b6a6-1b7778585d51")
  UUID getId();

  @NotNull
  @Schema(
      description = "The unique identifier of the country associated with this city",
      requiredMode = REQUIRED,
      example = "e9ee4c87-8633-4393-b6a6-1b7778585d51")
  UUID getCountryId();

  @NotNull
  @NotEmpty
  @NotBlank
  @Size(min = 1, max = 100)
  @Schema(description = "The name of the city", requiredMode = REQUIRED, example = "Košice")
  String getName();
}
