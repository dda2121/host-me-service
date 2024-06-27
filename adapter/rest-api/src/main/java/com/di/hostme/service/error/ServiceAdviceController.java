package com.di.hostme.service.error;

import static com.di.hostme.service.error.ApiErrorCode.BAD_REQUEST;

import com.di.hostme.service.controller.BaseController;
import com.di.hostme.service.domain.shared.common.error.BusinessError;
import com.di.hostme.service.domain.shared.common.error.BusinessException;
import com.di.hostme.service.rest.api.dto.common.error.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

// TODO: https://dmytrodemianenko21.atlassian.net/browse/KAN-10
@RestControllerAdvice
public class ServiceAdviceController {

  public static final Logger log = LoggerFactory.getLogger(ServiceAdviceController.class);

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponse> handle(BusinessException e) {
    log.error("Handle '{}'.", e.getClass().getName(), e);
    return mapErrorToResponse(e.getBusinessError());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException e) {
    log.error("Handle '{}'.", e.getClass().getName(), e);
    return mapErrorToResponse(BAD_REQUEST.createError(e.getParameter().getParameterName()));
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorResponse> handle(MethodArgumentTypeMismatchException e) {
    log.error("Handle '{}'.", e.getClass().getName(), e);
    return mapErrorToResponse(BAD_REQUEST.createError(e.getParameter().getParameterName()));
  }

  public ResponseEntity<ErrorResponse> mapErrorToResponse(final BusinessError businessError) {
    return BaseController.mapErrorToResponse(businessError);
  }
}
