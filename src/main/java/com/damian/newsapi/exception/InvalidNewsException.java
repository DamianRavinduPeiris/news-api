package com.damian.newsapi.exception;

public class InvalidNewsException extends RuntimeException {
    public InvalidNewsException(String message) {
        super(message);
    }
}

