package com.mafei.demo.model;

import com.mafei.demo.UniqueFieldID;
import lombok.Data;

import javax.validation.constraints.NotNull;

/*
  @Author kalhara@bowsin
  @Created 12/20/2020 10:04 PM  
*/
@Data
public class UserAddress {
    @NotNull(message = "address can't be null.")
    @UniqueFieldID(uniqueId = "80427464-8f3e-4016-9feb-20c78ffa405f")
    private String address;
}