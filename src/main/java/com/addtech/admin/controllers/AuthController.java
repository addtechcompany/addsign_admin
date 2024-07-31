package com.addtech.admin.controllers;

import com.addtech.admin.exceptions.ConflictException;
import com.addtech.admin.payload.request.AdminUsersRequest;
import com.addtech.admin.payload.response.JwtAuthenticationResponse;
import com.addtech.admin.services.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Аутентификация", description = "Аутентификация пользователя")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService iAuthService;


    @PostMapping("/auth")
    @Operation(summary = "Аутентификация по логину админа")
    public JwtAuthenticationResponse authByAdmin(@Valid @RequestBody AdminUsersRequest auth) throws ConflictException {
        return iAuthService.authByAdminUser(auth);
    }
}
