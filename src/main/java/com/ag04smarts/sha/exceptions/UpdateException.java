package com.ag04smarts.sha.exceptions;

public class UpdateException extends RuntimeException {

    public UpdateException(){
        super("Update cannot be executed.");
    }
}
