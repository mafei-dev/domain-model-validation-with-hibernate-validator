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
public @interface FrontFieldName {
    /**
     * @return
     * @apiNote The name from the front
     */
    String name();

    FrontFieldError[] errors() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
