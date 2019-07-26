package com.poc.contract.integration.exception;

public class BadRequestException extends Exception {
  public BadRequestException(String message) {
    super(message);
  }
}
