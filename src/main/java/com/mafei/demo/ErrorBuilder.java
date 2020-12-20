package com.mafei.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.ObjectError;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
  @Author kalhara@bowsin
  @Created 12/21/2020 1:12 AM  
*/
public class ErrorBuilder {
    public static ObjectError build(String errorCode, ErrorBuildData... objectTree) {


        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, objectTree.length).forEach(index -> {
            stringBuilder.append(FieldAnnotation.getFieldNameByUniqueId(objectTree[index].getUniqueID(), objectTree[index].getRelatedClass()));
            if ((objectTree.length - 1) != index) {
                stringBuilder.append(".");
            }
        });

        return new ObjectError(stringBuilder.toString(),
                FieldAnnotation.getFieldErrorValueByUniqueID(
                        FieldAnnotation.getFieldByUniqueId(
                                objectTree[objectTree.length - 1].getUniqueID(),
                                objectTree[objectTree.length - 1].getRelatedClass()
                        ),
                        errorCode)
        );
    }


}
