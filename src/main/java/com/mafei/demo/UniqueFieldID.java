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
public @interface UniqueFieldID {
    /**
     * @return
     * @apiNote when you annotate a field you must put a UUID for this.
     * the you can identify the field anywhere although the filed is changed
     */
    String uniqueId();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
