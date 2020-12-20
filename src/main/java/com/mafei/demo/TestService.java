package com.mafei.demo;

import com.mafei.demo.model.User;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.validation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Field;

/*
  @Author kalhara@bowsin
  @Created 12/21/2020 12:06 AM  
*/
@Service
public class TestService {


    public Object index(User user, BindingResult result) throws MethodArgumentNotValidException {

        result.addError(
                ErrorBuilder.build
                        (
                                User.email_error_9ee138cd,
                                new ErrorBuildData(
                                        User.address_3f0599c8,
                                        user.getClass()
                                ),
                                new ErrorBuildData(
                                        User.email_80427464,
                                        user.getClass()
                                )
                        )
        );

        return result.getAllErrors();
    }
}
