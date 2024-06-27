package com.di.hostme.service.domain.city.error;

import com.di.hostme.service.domain.shared.common.error.ErrorCode;
import com.di.hostme.service.domain.shared.common.error.ErrorCodeType;

public enum CityErrorCode implements ErrorCode {
  CITY_DOES_NOT_EXIST(
      ErrorCodeType.NOT_FOUND, "City with id '%s' for country with id '%s' does not exist.");

  private final ErrorCodeType errorCodeType;
  private final String template;

  CityErrorCode(ErrorCodeType errorCodeType, String template) {
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
