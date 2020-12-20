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
        return getFieldByUniqueId(uniqueId, baseClass).getName();
    }


    public static String getFieldErrorValueByName(Field field, String errorName) {
        for (FrontFieldName frontFieldName : field.getDeclaredAnnotationsByType(FrontFieldName.class)) {
            for (FrontFieldError error : frontFieldName.errors()) {
                if (error.name().equals(errorName)) {
                    return error.value();
                }
            }


        }
        return null;
    }

    public static String getFieldErrorValueByUniqueID(Field field, String UniqueID) {
        for (FrontFieldName frontFieldName : field.getDeclaredAnnotationsByType(FrontFieldName.class)) {
            for (FrontFieldError error : frontFieldName.errors()) {
                if (error.uniqueID().equals(UniqueID)) {
                    return error.value();
                }
            }
        }
        return null;
    }

}