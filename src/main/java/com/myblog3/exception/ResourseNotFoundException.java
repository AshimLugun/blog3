package com.myblog3.exception;

public class ResourseNotFoundException extends RuntimeException{
    public ResourseNotFoundException(String message){
        super(message);
    }
}
