package com.aleksandr.card_transfer.exceptions;

public class OperationIdNotFountErrorResponse {

    private String message;
    private String  id;
    private final String ERROR_MESSAGE = "Error customer message";

    public String getMessage() {
        return message;
    }

    public String  getId() {
        return id;
    }

    public OperationIdNotFountErrorResponse(String  id) {
        this.message = ERROR_MESSAGE;
        this.id = id;
    }
}
