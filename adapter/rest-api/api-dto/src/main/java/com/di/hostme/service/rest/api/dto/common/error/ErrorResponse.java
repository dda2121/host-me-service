package com.di.hostme.service.rest.api.dto.common.error;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import org.immutables.value.Value;

@JsonSerialize(as = ImmutableErrorResponse.class)
@JsonDeserialize(as = ImmutableErrorResponse.class)
@Value.Immutable
public interface ErrorResponse {

  @Schema(
      description = "The name of the service that generated the error response",
      requiredMode = REQUIRED,
      example = "host-me-service")
  String serviceName();

  @Schema(
      description = "List of error details explaining the cause of the failure",
      requiredMode = REQUIRED,
      example =
          """
            [
              {
                "code": "COUNTRY_DOES_NOT_EXIST",
                "message": "Country with id '%s' does not exist.",
                "messageParameters": [
                  "e9ee4c87-8633-4393-b6a6-1b7778585d51"
                ]
              }
            ]
          """)
  List<ErrorResponseFault> errorResponseFaults();
}
