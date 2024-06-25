package com.di.hostme.service.rest.api.dto.common.error;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import org.immutables.value.Value;

@JsonSerialize(as = ImmutableErrorResponse.class)
@JsonDeserialize(as = ImmutableErrorResponse.class)
@Value.Immutable
public interface ErrorResponse {

  String serviceName();

  List<ErrorResponseFault> errorResponseFaults();
}
