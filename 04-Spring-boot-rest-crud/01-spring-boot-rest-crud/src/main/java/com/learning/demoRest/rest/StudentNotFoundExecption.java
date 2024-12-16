package com.learning.demoRest.rest;

public class StudentNotFoundExecption extends RuntimeException{
    public StudentNotFoundExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundExecption(Throwable cause) {
        super(cause);
    }

    public StudentNotFoundExecption(String message) {
        super(message);
    }
}