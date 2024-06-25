package com.di.hostme.service.error;

import com.di.hostme.service.controller.BaseController;
import com.di.hostme.service.domain.shared.common.error.BusinessError;
import com.di.hostme.service.domain.shared.common.error.BusinessException;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceAdviceController {

  public static final Logger log = LoggerFactory.getLogger(ServiceAdviceController.class);

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponse> handle(BusinessException e) {
    log.error("Handle '{}'.", e.getClass().getName(), e);
    return mapErrorToResponse(e.getBusinessError());
  }

  public ResponseEntity<ErrorResponse> mapErrorToResponse(final BusinessError businessError) {
    return BaseController.mapErrorToResponse(businessError);
  }
}
