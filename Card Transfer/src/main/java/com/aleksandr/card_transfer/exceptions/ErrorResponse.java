package com.aleksandr.card_transfer.exceptions;

public class ErrorResponse
{
    private String message;
    private Integer id;
    private final String ERROR_MESSAGE = "Error customer message.";

    public ErrorResponse(String errorFields) {
        this.message = ERROR_MESSAGE + errorFields;
    }

    public String getMessage() {
        return message;
    }
    public ErrorResponse(Integer id) {
        this.message = ERROR_MESSAGE;
        this.id = id;
    }
}
