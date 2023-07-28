package com.vigulear.rbac.backend.exception_handlig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author kosta on 4/3/2023.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<IncorrectData> handleException(NoSuchDataException exception) {
    IncorrectData data = new IncorrectData();
    data.setInfo(exception.getMessage());

    return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
  }
}
