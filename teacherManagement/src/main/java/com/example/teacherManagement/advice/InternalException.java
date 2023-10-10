package com.example.teacherManagement.advice;

import com.example.teacherManagement.exceptions.ApiRequestException;
import com.example.teacherManagement.exceptions.ExceptionModel;
import com.example.teacherManagement.exceptions.UserExistException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class InternalException extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionModel exceptionModel = new ExceptionModel(ex.getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST.name());
        return ResponseEntity.badRequest().body(exceptionModel);
    }
    @ExceptionHandler(UserExistException.class)
    private ResponseEntity<ExceptionModel> handleUserExistException(UserExistException ex){
        ExceptionModel exceptionModel=new ExceptionModel(ex.getMessage(),HttpStatus.BAD_REQUEST.name());
        return ResponseEntity.badRequest().body(exceptionModel);

    }
    @ExceptionHandler(ApiRequestException.class)
    private ResponseEntity<Object>handleApiRequeException(ApiRequestException ex){
    ExceptionModel exceptionModel=new ExceptionModel(ex.getMessage(),HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
//    return new ResponseEntity<>(exceptionModel,HttpStatus.BAD_REQUEST);
        return ResponseEntity.badRequest().body(exceptionModel);
    }

}
