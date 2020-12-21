package com.mafei.demo.model;

/*
  @Author kalhara@bowsin
  @Created 12/21/2020 11:06 AM  
*/

import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class BeanValidateException extends RuntimeException {

    private List<ObjectError> objectErrors=new ArrayList<>();

    public BeanValidateException(List<ObjectError> objectErrors) {
        setObjectErrors(objectErrors);
    }

    public BeanValidateException(String message) {
        super(message);
    }

    public List<ObjectError> getObjectErrors() {
        return objectErrors;
    }

    public void setObjectErrors(List<ObjectError> objectErrors) {
        this.objectErrors = objectErrors;
    }
}
