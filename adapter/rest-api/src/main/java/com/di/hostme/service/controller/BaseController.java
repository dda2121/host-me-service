package com.di.hostme.service.controller;

import com.di.hostme.service.business.AbstractService;
import com.di.hostme.service.domain.shared.common.error.BusinessError;
import com.di.hostme.service.mapper.ErrorResponseMapper;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponse;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

  public static final String BASE_URI = "/v1/api/host-me";

  public static ResponseEntity<ErrorResponse> mapErrorToResponse(BusinessError businessError) {
    return ErrorResponseMapper.mapErrorToResponse(businessError, AbstractService.SERVICE_NAME);
  }
}
