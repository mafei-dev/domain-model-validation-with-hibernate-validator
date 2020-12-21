package com.mafei.demo.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/*
  @Author kalhara@bowsin
  @Created 12/21/2020 5:52 PM  
*/
@Data
public class UserContacts {
    @NotEmpty(message = "cannot be empty")
    private @Valid List<@NotNull @NotBlank(message = "blank") String> contactList;
}
