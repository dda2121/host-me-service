package com.di.hostme.service.domain.shared.common.error;

public class BusinessException extends RuntimeException {

  private final BusinessError businessError;

  public BusinessException(String message, BusinessError businessError) {
    super(message, businessError.getCause());
    this.businessError = businessError;
  }

  public BusinessError getBusinessError() {
    return businessError;
  }
}
