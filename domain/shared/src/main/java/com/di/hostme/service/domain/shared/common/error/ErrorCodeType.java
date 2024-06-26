package com.di.hostme.service.domain.shared.common.error;

public enum ErrorCodeType {
  BAD_REQUEST(400),
  NOT_FOUND(404);

  private final int errorCode;

  ErrorCodeType(int errorCode) {
    this.errorCode = errorCode;
  }

  public int getCode() {
    return errorCode;
  }
}
