package com.di.hostme.service.rest.api.dto.common.error;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import org.immutables.value.Value;

@JsonDeserialize(as = ImmutableErrorResponseList.class)
@JsonSerialize(as = ImmutableErrorResponseList.class)
@Value.Style(stagedBuilder = true)
@Value.Immutable
public interface ErrorResponseList {

  String serviceName();

  List<ErrorResponse> faults();
}
