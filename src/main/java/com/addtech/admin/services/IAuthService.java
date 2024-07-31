package com.addtech.admin.services;

import com.addtech.admin.exceptions.ConflictException;
import com.addtech.admin.payload.request.AdminUsersRequest;
import com.addtech.admin.payload.response.JwtAuthenticationResponse;

public interface IAuthService {
    /**
     * Авторизация по логину и паролю
     * <p>
     * Управление админ панель
     *
     * @param request дто для авторизации
     * @return токен
     * @throws ConflictException Ошибка
     */
    JwtAuthenticationResponse authByAdminUser(AdminUsersRequest request) throws ConflictException;
}
