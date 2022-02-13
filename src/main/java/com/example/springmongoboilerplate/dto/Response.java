package com.example.springmongoboilerplate.dto;

import com.example.springmongoboilerplate.common.ResponseType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Getter
public class Response<T> {

  private Integer code;
  private T data;

  public static <T> Response<T> of(T data) {
    var res = new Response<T>();
    res.data = data;
    return res;
  }

  public static Response<Void> of(ResponseType responseType) {
    var res = new Response<Void>();
    res.code = responseType.getValue();
    return res;
  }
}
