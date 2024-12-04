package com.backend.tes.exception;

public class RecordNotFoundException extends  RuntimeException {

    public RecordNotFoundException(String message) {
        super(message);
    }
}
