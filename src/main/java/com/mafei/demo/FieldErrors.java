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
public @interface FieldErrors {
    /**
     * @return
     * @apiNote The name from the front
     */
    String name();

    FieldError[] errors() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
