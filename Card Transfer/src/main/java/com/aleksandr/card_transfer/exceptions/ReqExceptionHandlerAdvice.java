package com.aleksandr.card_transfer.exceptions;


import com.aleksandr.card_transfer.integrationModel.ConfirmReq;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class ReqExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validationDataFailed(MethodArgumentNotValidException e) {

        StringBuilder errors = new StringBuilder();

        for (ObjectError error: e.getBindingResult().getFieldErrors()) {
            String fieldName =  ((FieldError) error).getField();
            String currentError = error.getDefaultMessage();
            errors.append(" " + fieldName + ": " +currentError + ";");
        }

        ErrorResponse errorResponse = new ErrorResponse(errors.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OperationIdNotFountErrorException.class)
    public ResponseEntity<OperationIdNotFountErrorResponse> validationDataFailed(OperationIdNotFountErrorException e, WebRequest webRequest) {
        ConfirmReq req = (ConfirmReq) webRequest.getAttribute("confirmReq", RequestAttributes.SCOPE_REQUEST);
        return new ResponseEntity<>(new OperationIdNotFountErrorResponse(req.getOperationId()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
