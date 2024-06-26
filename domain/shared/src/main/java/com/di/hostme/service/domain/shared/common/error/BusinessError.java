package com.di.hostme.service.domain.shared.common.error;

import java.util.List;
import org.immutables.value.Value;

@Value.Immutable
public abstract class BusinessError extends Throwable {

  @Value.Parameter
  public abstract ErrorCode errorCode();

  @Value.Parameter
  public abstract List<String> parameters();

  public BusinessException convertToException() {
    return new BusinessException(message(), this);
  }

  @Value.Derived
  public String message() {
    return String.format(this.errorCode().template(), this.parameters().toArray());
  }

  @Override
  public String getMessage() {
    return message();
  }
}
