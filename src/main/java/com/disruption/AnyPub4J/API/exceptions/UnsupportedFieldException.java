package com.disruption.AnyPub4J.API.exceptions;

public class UnsupportedFieldException extends Throwable {
    @Override
    public String getMessage() {
        return "This instance does not support this field.";
    }
}
