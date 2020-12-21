package com.mafei.demo;

import lombok.Data;

import java.lang.reflect.Type;
import java.util.Map;

/*
  @Author kalhara@bowsin
  @Created 12/21/2020 11:50 AM  
*/
@Data
public class ErrorResponse {

    private String errorTypeType;
    private Map<String, Object> error;

    public class Type {
        public static final String BEAN_ERROR = "BEAN_ERROR";
        public static final String OPERATION_ERROR = "OPERATION_ERROR";
    }
}
