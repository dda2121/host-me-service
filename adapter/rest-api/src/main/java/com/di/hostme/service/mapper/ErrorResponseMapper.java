package com.di.hostme.service.mapper;

import com.di.hostme.service.domain.shared.common.error.BusinessError;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponse;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponseFault;
import com.di.hostme.service.rest.api.dto.common.error.ImmutableErrorResponse;
import com.di.hostme.service.rest.api.dto.common.error.ImmutableErrorResponseFault;
import java.util.List;
import org.springframework.http.ResponseEntity;

// TODO: https://dmytrodemianenko21.atlassian.net/browse/KAN-11
public final class ErrorResponseMapper {

  public static ResponseEntity<ErrorResponse> mapErrorToResponse(
      BusinessError businessError, String serviceName) {
    final ErrorResponseFault errorResponseFault =
        ImmutableErrorResponseFault.builder()
            .code(businessError.errorCode().toString())
            .message(businessError.errorCode().template())
            .addAllMessageParameters(businessError.parameters())
            .build();

    return ResponseEntity.status(businessError.errorCode().errorCodeType().getCode())
        .body(
            ImmutableErrorResponse.builder()
                .serviceName(serviceName)
                .addAllErrorResponseFaults(List.of(errorResponseFault))
                .build());
  }
}
