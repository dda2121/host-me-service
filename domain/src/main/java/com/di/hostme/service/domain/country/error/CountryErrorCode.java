package com.di.hostme.service.domain.country.error;

import com.di.hostme.service.domain.shared.common.error.ErrorCode;
import com.di.hostme.service.domain.shared.common.error.ErrorCodeType;

public enum CountryErrorCode implements ErrorCode {
  COUNTRY_DOES_NOT_EXIST(ErrorCodeType.NOT_FOUND, "Country with id '%s' does not exist.");

  private final ErrorCodeType errorCodeType;
  private final String template;

  CountryErrorCode(ErrorCodeType errorCodeType, String template) {
    this.errorCodeType = errorCodeType;
    this.template = template;
  }

  @Override
  public String template() {
    return template;
  }

  @Override
  public ErrorCodeType errorCodeType() {
    return errorCodeType;
  }
}
