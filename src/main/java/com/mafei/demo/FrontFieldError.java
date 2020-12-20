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
public @interface FrontFieldError {
    /**
     * @return
     * @apiNote The error name
     */
    String name();


    String uniqueID();

    /**
     * @return
     * @apiNote The error value for error
     */
    String value();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
