package com.vigulear.rbac.backend.exception_handlig;

/**
 * @author kosta on 4/3/2023.
 */
public class NoSuchDataException extends RuntimeException {

  public NoSuchDataException(String message) {
    super(message);
  }
}
