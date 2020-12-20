package com.mafei.demo.model;

import com.mafei.demo.FrontFieldError;
import com.mafei.demo.FrontFieldName;
import com.mafei.demo.UniqueFieldID;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/*
  @Author kalhara@bowsin
  @Created 12/20/2020 9:33 PM  
*/

@Data
public class User {

    @NotNull(message = "user name can't be null.")
    private String username;

    @NotNull(message = "user name can't be null.")
    private String male;

    @NotNull(message = "user name can't be null.")
    @Email(message = "email can't be null.")


    public static final String email_80427464 = "email_80427464";
    @UniqueFieldID(uniqueId = email_80427464)
    public static final String email_error_9ee138cd = "email_error_9ee138cd";
    public static final String email_error_ec8b25e6 = "email_error_ec8b25e6";
    @FrontFieldName(name = "Merchant name", errors = {
            @FrontFieldError(
                    name = "duplicate",
                    uniqueID = email_error_9ee138cd,
                    value = "Merchant name has been duplicated."
            ),
            @FrontFieldError(
                    name = "received",
                    uniqueID = email_error_ec8b25e6,
                    value = "Merchant name has been duplicated."
            ),

    })
    private String email;



    public static final String address_3f0599c8 = "address_3f0599c8";
    @NotNull(message = "address can't be null.")
    @UniqueFieldID(uniqueId = address_3f0599c8)
    private @Valid UserAddress address;
}
