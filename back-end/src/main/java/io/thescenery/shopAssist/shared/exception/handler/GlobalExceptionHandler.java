package io.thescenery.shopAssist.shared.exception.handler;

import io.thescenery.shopAssist.shared.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String exceptionHandler(Exception ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String notFoundExceptionHandler(Exception ex) {
    return ex.getMessage();
  }
}
