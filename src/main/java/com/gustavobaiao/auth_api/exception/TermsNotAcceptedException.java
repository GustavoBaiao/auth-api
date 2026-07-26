package com.gustavobaiao.auth_api.exception;

public class TermsNotAcceptedException extends RuntimeException {

    public TermsNotAcceptedException(String message) {
        super(message);
    }
}
