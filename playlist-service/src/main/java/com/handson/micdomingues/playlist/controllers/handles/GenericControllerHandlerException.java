package com.handson.micdomingues.playlist.controllers.handles;

import com.handson.micdomingues.playlist.exceptions.BusinessException;
import com.handson.micdomingues.playlist.exceptions.mensagens.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerHandlerException {


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusinessException(BusinessException exception) {
        return new ResponseEntity<>(new ApiError(exception.getMessagem().getValue()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception exception) {
        return new ResponseEntity<>(new ApiError(ErrorMessages.ERRO_INTERNO.getValue()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


