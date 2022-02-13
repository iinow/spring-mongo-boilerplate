package com.example.springmongoboilerplate.exception;

import com.example.springmongoboilerplate.common.ResponseType;
import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {

  public static final CommonException EXCEPTION = new CommonException(ResponseType.UNKNOWN);

  private final ResponseType responseType;

  public CommonException(ResponseType responseType) {
    this.responseType = responseType;
  }

  public CommonException(ResponseType responseType, String message) {
    super(message);
    this.responseType = responseType;
  }
}
