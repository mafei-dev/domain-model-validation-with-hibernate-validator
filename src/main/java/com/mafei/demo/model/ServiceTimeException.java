package com.mafei.demo.model;

/*
  @Author kalhara@bowsin
  @Created 12/21/2020 11:06 AM  
*/

import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceTimeException extends RuntimeException {

    private List<ObjectError> objectErrors=new ArrayList<>();

    public ServiceTimeException(List<ObjectError> objectErrors) {
        setObjectErrors(objectErrors);
    }

    public ServiceTimeException(String message) {
        super(message);
    }

    public List<ObjectError> getObjectErrors() {
        return objectErrors;
    }

    public void setObjectErrors(List<ObjectError> objectErrors) {
        this.objectErrors = objectErrors;
    }
}
