package com.di.hostme.service.domain.common.error;

import java.util.List;
import org.immutables.value.Value;

@Value.Immutable
public abstract class BusinessError extends Throwable {

  @Value.Parameter
  public abstract ErrorCode errorCode();

  @Value.Parameter
  public abstract List<String> parameters();

  @Value.Derived
  public String message() {
    return String.format(this.errorCode().template(), this.parameters().toArray());
  }

  public static BusinessError of(ErrorCode errorCode, List<String> params) {
    return ImmutableBusinessError.of(errorCode, params);
  }

  public BusinessException convertToException() {
    return new BusinessException(message(), this);
  }

  @Override
  public String getMessage() {
    return message();
  }
}
