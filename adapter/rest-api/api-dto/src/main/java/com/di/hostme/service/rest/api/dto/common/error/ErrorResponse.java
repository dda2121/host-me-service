package com.di.hostme.service.rest.api.dto.common.error;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import org.immutables.value.Value;

@JsonDeserialize(as = ImmutableErrorResponse.class)
@JsonSerialize(as = ImmutableErrorResponse.class)
@Value.Style(stagedBuilder = true)
@Value.Immutable
public interface ErrorResponse {

  String faultCode();

  String faultMessage();

  List<String> faultMessageParameters();
}
