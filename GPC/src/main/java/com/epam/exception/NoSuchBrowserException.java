package com.epam.exception;

public class NoSuchBrowserException extends RuntimeException{

    public NoSuchBrowserException(String message){
        super(message);
    }
}
