package com.mafei.demo;

import com.mafei.demo.model.BeanValidateException;
import com.mafei.demo.model.ServiceTimeException;
import com.mafei.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
  @Author kalhara@bowsin
  @Created 12/20/2020 9:32 PM  
*/
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping("/index")
    public Object index(@RequestBody @Validated User user, BindingResult result) throws BeanValidateException {
        System.out.println("result = " + result);
        if (result.hasErrors()) {
            throw new BeanValidateException(result.getAllErrors());
        }
        return testService.index(user, result);
    }
}
