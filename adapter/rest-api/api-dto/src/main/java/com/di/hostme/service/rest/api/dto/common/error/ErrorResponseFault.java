package com.di.hostme.service.rest.api.dto.common.error;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import org.immutables.value.Value;

@JsonSerialize(as = ImmutableErrorResponseFault.class)
@JsonDeserialize(as = ImmutableErrorResponseFault.class)
@Value.Immutable
public interface ErrorResponseFault {

  String code();

  String message();

  List<String> messageParameters();
}
