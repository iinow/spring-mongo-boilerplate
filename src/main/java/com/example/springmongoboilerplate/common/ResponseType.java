package com.example.springmongoboilerplate.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseType {

  OK(0),
  UNKNOWN(-1),
  USER_NOT_FOUND(10),
  ;

  private final int value;
}
