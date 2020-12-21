package com.mafei.demo;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  @Author kalhara@bowsin
  @Created 12/20/2020 11:30 PM  
*/

public class ErrorJSON {

    public static Map<String, Object> toJSON(List<ObjectError> errorList) {
        Map<String, Object> errors = new HashMap<>();
        for (Object error : errorList) {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                Map<String, Object> fError = new HashMap<>();
                fError.put("message", fieldError.getDefaultMessage());
                fError.put("code", fieldError.getCode());
                errors.put(fieldError.getField(), fError);
            }
           /* if (error instanceof ObjectError) {
                ObjectError objectError = (ObjectError) error;
                errors.put(objectError.getObjectName(), objectError.getDefaultMessage());
            }*/
        }
        return errors;
    }
}

