package com.example.teacherManagement.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionModel {
    private  String message;
    private  String errorcode;
    private Throwable throwable;
    private ZonedDateTime timestamp;
    private HttpStatus httpStatus;

    public ExceptionModel(String message, String name) {
    }

    public ExceptionModel(String message, HttpStatus httpStatus, ZonedDateTime z) {
    }
}
