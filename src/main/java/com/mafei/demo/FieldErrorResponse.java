package com.mafei.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Field;

/*
  @Author kalhara@bowsin
  @Created 12/21/2020 1:51 PM  
*/
@Data
@AllArgsConstructor
public class FieldErrorResponse {
    private Field field;
    private String errorCode;
    private String errorMessage;
}
