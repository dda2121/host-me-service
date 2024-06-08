package com.di.hostme.service.error;

import com.di.hostme.service.domain.common.error.ErrorCode;
import com.di.hostme.service.domain.common.error.ErrorCodeType;

public enum ApiErrorCode implements ErrorCode {

  BAD_REQUEST(ErrorCodeType.BAD_REQUEST, "Invalid request parameters.");

  private final ErrorCodeType errorCodeType;
  private final String template;

  ApiErrorCode(ErrorCodeType errorCodeType, String template) {
    this.errorCodeType = errorCodeType;
    this.template = template;
  }

  @Override
  public String template() {
    return this.template;
  }

  @Override
  public ErrorCodeType errorCodeType() {
    return this.errorCodeType;
  }
}
