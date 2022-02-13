package com.example.springmongoboilerplate.api;

import com.example.springmongoboilerplate.common.ResponseType;
import com.example.springmongoboilerplate.dto.Response;
import com.example.springmongoboilerplate.exception.CommonException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ErrorController {

  @ExceptionHandler(CommonException.class)
  public ResponseEntity<Response<Void>> handleCommonException(CommonException exception) {
    return ResponseEntity.ok(Response.of(exception.getResponseType()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Response<Void>> handleException(Exception e) {
    log.error("message: {}", e.getMessage(), e);
    return ResponseEntity.ok(Response.of(ResponseType.UNKNOWN));
  }
}
