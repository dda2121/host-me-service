package com.di.hostme.service.rest.api.dto.common.error;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import org.immutables.value.Value;

@JsonSerialize(as = ImmutableErrorResponseFault.class)
@JsonDeserialize(as = ImmutableErrorResponseFault.class)
@Value.Immutable
public interface ErrorResponseFault {

  @Schema(
      description = "The error code associated with the fault",
      example = "COUNTRY_DOES_NOT_EXIST")
  String code();

  @Schema(
      description = "A descriptive message explaining the error",
      example = "Country with id '%s' does not exist.")
  String message();

  @Schema(
      description = "List of parameters used in the error message for more specific context",
      example = "e9ee4c87-8633-4393-b6a6-1b7778585d51")
  List<String> messageParameters();
}
