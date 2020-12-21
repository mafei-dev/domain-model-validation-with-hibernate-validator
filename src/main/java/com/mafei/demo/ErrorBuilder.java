package com.mafei.demo;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.stream.IntStream;

/*
  @Author kalhara@bowsin
  @Created 12/21/2020 1:12 AM  
*/
public class ErrorBuilder {
    public static ObjectError buildWithCode(Object rejectedValue, String errorCode, ErrorBuildData... objectTree) {


        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, objectTree.length).forEach(index -> {
            stringBuilder.append(FieldAnnotation.getFieldNameByUniqueId(objectTree[index].getUniqueID(), objectTree[index].getRelatedClass()));
            if ((objectTree.length - 1) != index) {
                stringBuilder.append(".");
            }
        });
        FieldErrorResponse errorResponse = FieldAnnotation.getFieldErrorValueByUniqueID(
                FieldAnnotation.getFieldByUniqueId(
                        objectTree[objectTree.length - 1].getUniqueID(),
                        objectTree[objectTree.length - 1].getRelatedClass()
                ),
                errorCode);

        return new FieldError("", stringBuilder.toString(), rejectedValue, false, new String[]{errorResponse.getErrorCode()}, null,
                errorResponse.getErrorMessage());
    }

    public static FieldError buildWithCustomMessage(String customMessage, String rejectedValue,
                                                    ErrorBuildData... objectTree) {

        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, objectTree.length).forEach(index -> {
            stringBuilder.append(FieldAnnotation.getFieldNameByUniqueId(objectTree[index].getUniqueID(), objectTree[index].getRelatedClass()));
            if ((objectTree.length - 1) != index) {
                stringBuilder.append(".");
            }
        });
        return new FieldError("", stringBuilder.toString(), rejectedValue, false, new String[]{}, null, customMessage);
    }

}
