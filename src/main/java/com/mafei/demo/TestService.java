package com.mafei.demo;

import com.mafei.demo.model.ServiceTimeException;
import com.mafei.demo.model.User;
import com.mafei.demo.model.UserAddress;
import org.springframework.stereotype.Service;
import org.springframework.validation.*;

/*
  @Author kalhara@bowsin
  @Created 12/21/2020 12:06 AM  
*/
@Service
public class TestService {


    public Object index(User user, BindingResult result) throws ServiceTimeException {

        result.addError(
                ErrorBuilder.buildWithCode
                        (
                                user.getAddress().getAddress(),
                                UserAddress._address_error_1,
                                new ErrorBuildData(
                                        User._address,
                                        User.class
                                ),
                                new ErrorBuildData(
                                        UserAddress._address,
                                        UserAddress.class
                                )
                        )
        );
        throw new ServiceTimeException(result.getAllErrors());
    }
}
