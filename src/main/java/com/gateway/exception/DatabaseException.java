package com.gateway.exception;

public class DatabaseException extends Exception {

    private static final long serialVersionUID = -7796022558881498495L;

    public DatabaseException(String error) {
        super(error);
    }

}
