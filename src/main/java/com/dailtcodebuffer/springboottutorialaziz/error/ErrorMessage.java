package com.dailtcodebuffer.springboottutorialaziz.error;

import org.springframework.http.HttpStatus;

import java.net.http.HttpRequest;

public class ErrorMessage {



    private String message;
    private HttpStatus status;

    public ErrorMessage(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public ErrorMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
