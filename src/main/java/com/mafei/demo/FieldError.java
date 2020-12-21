package com.mafei.demo;

import javax.validation.Payload;
import java.lang.annotation.*;

/*
  @Author kalhara@bowsin
  @Created 12/21/2020 12:53 AM  
*/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldError {
    /**
     * @return
     * @apiNote The error name
     */
    String name();

    /**
     * @return
     * @apiNote this error related to the api doc
     */
    String errorCode();


    String uniqueID();

    /**
     * @return
     * @apiNote The error value for error
     */
    String errorMessage();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
