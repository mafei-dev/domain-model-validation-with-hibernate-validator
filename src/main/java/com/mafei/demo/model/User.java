package com.mafei.demo.model;

import com.mafei.demo.FieldError;
import com.mafei.demo.FieldErrors;
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


    //<email
    @UniqueFieldID(uniqueId = _email)
    @FieldErrors(name = "email", errors = {
            @FieldError(
                    name = "duplicate",
                    uniqueID = _email_error_1,
                    errorMessage = _email_error_1,
                    errorCode = "sdsd"
            ),
            @FieldError(
                    name = "received",
                    uniqueID = _email_error_2,
                    errorMessage = _email_error_2,
                    errorCode = "ffd"
            ),

    })
    @NotNull(message = "user name can't be null.")
    @Email(message = "invalid email")
    private String email;
    public static final String _email = "email";
    public static final String _email_error_1 = "Merchant name has been duplicated.";
    public static final String _email_error_2 = "Merchant name has been received.";
    //email>


    //<address
    @NotNull(message = "address can't be null.")
    @UniqueFieldID(uniqueId = _address)
    private @Valid UserAddress address;
    public static final String _address = "address";
    //address>

    //<UserContacts

    @NotNull(message = "userContacts can't be null.")
    private @Valid UserContacts userContacts;
    //UserContacts>
}
