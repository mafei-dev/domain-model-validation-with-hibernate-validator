package com.mafei.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mafei.demo.model.BeanValidateException;
import com.mafei.demo.model.ServiceTimeException;
import lombok.SneakyThrows;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
  @Author kalhara@bowsin
  @Created 12/20/2020 10:26 PM  
*/
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends
        ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                          HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorTypeType(ErrorResponse.Type.BEAN_ERROR);


        response.setError(ErrorJSON.toJSON(ex.getAllErrors()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler({ServiceTimeException.class})
    public ResponseEntity error(ServiceTimeException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorTypeType(ErrorResponse.Type.OPERATION_ERROR);
        response.setError(ErrorJSON.toJSON(ex.getObjectErrors()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler({BeanValidateException.class})
    public ResponseEntity error(BeanValidateException ex) {
        System.out.println("ex = " + ex);
        ErrorResponse response = new ErrorResponse();
        response.setErrorTypeType(ErrorResponse.Type.BEAN_ERROR);
        response.setError(ErrorJSON.toJSON(ex.getObjectErrors()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("messageNotReadableException = " + ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex);
    }


}