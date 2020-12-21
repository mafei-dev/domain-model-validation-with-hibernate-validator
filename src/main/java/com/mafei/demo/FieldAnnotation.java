package com.mafei.demo;

import java.lang.reflect.Field;

/*
  @Author kalhara@bowsin
  @Created 12/21/2020 12:52 AM  
*/
public class FieldAnnotation {
    public static Field getFieldByUniqueId(String uniqueId, Class<?> baseClass) {
        for (Field field : baseClass.getDeclaredFields()) {
            if (field.getDeclaredAnnotation(UniqueFieldID.class) != null) {
                if (field.getDeclaredAnnotation(UniqueFieldID.class).uniqueId().equals(uniqueId)) {
                    return field;
                }
            }
        }
        return null;
    }

    public static String getFieldNameByUniqueId(String uniqueId, Class<?> baseClass) {
        Field fieldByUniqueId = getFieldByUniqueId(uniqueId, baseClass);
       /* for (FieldError error : fieldByUniqueId.getDeclaredAnnotation(FieldErrors.class).errors()) {
            if ()
        }*/
        return getFieldByUniqueId(uniqueId, baseClass).getName();
    }


    public static String getFieldErrorValueByName(Field field, String errorName) {
        for (FieldErrors fieldErrors : field.getDeclaredAnnotationsByType(FieldErrors.class)) {
            for (FieldError error : fieldErrors.errors()) {
                if (error.name().equals(errorName)) {
                    return error.errorMessage();
                }
            }

        }
        return null;
    }

    public static FieldErrorResponse getFieldErrorValueByUniqueID(Field field, String UniqueID) {
        System.out.println("field = " + field);
        for (FieldErrors fieldErrors : field.getDeclaredAnnotationsByType(FieldErrors.class)) {
            System.out.println("fieldErrors = " + fieldErrors);
            for (FieldError error : fieldErrors.errors()) {
                System.out.println("error = " + error);
                if (error.uniqueID().equals(UniqueID)) {
                    return new FieldErrorResponse(field, error.errorCode(),error.errorMessage());
//                    return error.value();
                }
            }
        }
        return null;
    }

}