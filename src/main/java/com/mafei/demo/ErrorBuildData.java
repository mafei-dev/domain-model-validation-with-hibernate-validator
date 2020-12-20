package com.mafei.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
  @Author kalhara@bowsin
  @Created 12/21/2020 1:44 AM  
*/
@Data
@AllArgsConstructor
public class ErrorBuildData {
    /**
     * @apiNote unique ID for filed
     */
    private String uniqueID;
    private Class relatedClass;
}
