package com.di.hostme.service.mapper;

import com.di.hostme.service.domain.common.error.BusinessError;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponse;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponseList;
import com.di.hostme.service.rest.api.dto.common.error.ImmutableErrorResponse;
import com.di.hostme.service.rest.api.dto.common.error.ImmutableErrorResponseList;
import java.util.List;
import org.springframework.http.ResponseEntity;

public class ErrorResponseMapper {

  public static ResponseEntity<ErrorResponseList> mapErrorToResponse(
      BusinessError businessError, String serviceName) {
    final ErrorResponse errorResponse =
        ImmutableErrorResponse.builder()
            .faultCode(businessError.errorCode().toString())
            .faultMessage(businessError.errorCode().template())
            .addAllFaultMessageParameters(businessError.parameters())
            .build();

    final ErrorResponseList errorResponseList =
        ImmutableErrorResponseList.builder()
            .serviceName(serviceName)
            .addAllFaults(List.of(errorResponse))
            .build();

    return ResponseEntity.status(businessError.errorCode().errorCodeType().getCode())
        .body(errorResponseList);
  }
}
