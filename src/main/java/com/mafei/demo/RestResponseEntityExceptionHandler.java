package com.mafei.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
  @Author kalhara@bowsin
  @Created 12/20/2020 10:26 PM  
*/
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends
        ResponseEntityExceptionHandler {
    @SneakyThrows
    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                          HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(ErrorJSON.toJSON(ex.getAllErrors()));

    }


    /*@Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(ex);

    }*/
}