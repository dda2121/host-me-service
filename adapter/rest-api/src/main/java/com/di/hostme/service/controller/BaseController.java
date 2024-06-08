package com.di.hostme.service.controller;

import com.di.hostme.service.business.AbstractService;
import com.di.hostme.service.domain.common.error.BusinessError;
import com.di.hostme.service.mapper.ErrorResponseMapper;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponseList;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

  public static final String BASE_URI = "/v1/api/host-me";

  public static ResponseEntity<ErrorResponseList> mapErrorToResponse(BusinessError businessError) {
    return ErrorResponseMapper.mapErrorToResponse(businessError, AbstractService.SERVICE_NAME);
  }
}
