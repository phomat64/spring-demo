package com.example.demo.domain.exceptions;

public class MailException extends RuntimeException {
    private final String errorMsg;

    public MailException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
