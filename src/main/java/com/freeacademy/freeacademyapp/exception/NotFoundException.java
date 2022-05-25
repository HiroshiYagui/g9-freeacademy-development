package com.freeacademy.freeacademyapp.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String Message){
        super(Message);
    }
}
