package com.di.hostme.service.domain.common.error;

public enum ErrorCodeType {
  BAD_REQUEST(400);

  private final int errorCode;

  ErrorCodeType(int errorCode) {
    this.errorCode = errorCode;
  }

  public int getCode() {
    return errorCode;
  }
}
