package com.addtech.admin.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminUsersRequest {

    @NotBlank(message = "login should not be blank")
    private String login;

    @NotBlank(message = "password should not be blank")
    private String password;
}
