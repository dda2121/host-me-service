package com.di.hostme.service.domain.shared.common.error;

import java.util.List;

public interface ErrorCode {

  ErrorCodeType errorCodeType();

  String template();

  default BusinessError createError(String... params) {
    return ImmutableBusinessError.of(this, List.of(params));
  }
}
