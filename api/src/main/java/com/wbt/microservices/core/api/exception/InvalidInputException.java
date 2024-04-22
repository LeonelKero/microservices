package com.wbt.microservices.core.api.exception;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message) {
        super(message);
    }
}
