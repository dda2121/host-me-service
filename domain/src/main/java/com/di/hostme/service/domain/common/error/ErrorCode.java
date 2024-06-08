package com.di.hostme.service.domain.common.error;

import java.util.List;

public interface ErrorCode {

  String template();

  ErrorCodeType errorCodeType();

  default BusinessError createError(String... params) {
    return BusinessError.of(this, List.of(params));
  }
}
