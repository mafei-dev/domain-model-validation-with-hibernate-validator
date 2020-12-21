package com.mafei.demo.model;

import com.mafei.demo.FieldError;
import com.mafei.demo.FieldErrors;
import com.mafei.demo.UniqueFieldID;
import lombok.Data;

import javax.validation.constraints.NotNull;

/*
  @Author kalhara@bowsin
  @Created 12/20/2020 10:04 PM  
*/
@Data
public class UserAddress {
    //<address
    @NotNull(message = "address can't be null.")
    @UniqueFieldID(uniqueId = _address)
    @FieldErrors(name = "address", errors = {
            @FieldError(name = "Address in correct",
                    uniqueID = _address_error_1,
                    errorMessage = _address_error_1,
                    errorCode = "bbbb"
            )
    })
    private String address;
    public static final String _address = "address";
    public static final String _address_error_1 = "Address is incorrect";
    //address>
}