package com.addtech.admin.services.impl;

import com.addtech.admin.exceptions.ConflictException;
import com.addtech.admin.models.AdminUser;
import com.addtech.admin.models.RefreshToken;
import com.addtech.admin.payload.request.AdminUsersRequest;
import com.addtech.admin.payload.response.JwtAuthenticationResponse;
import com.addtech.admin.repositories.AdminUserRepository;
import com.addtech.admin.security.CustomUserDetails;
import com.addtech.admin.security.CustomUserDetailsService;
import com.addtech.admin.security.JwtTokenProvider;
import com.addtech.admin.security.RefreshTokenService;
import com.addtech.admin.services.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final AdminUserRepository adminUserRepository;
    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;

    @Override
    public JwtAuthenticationResponse authByAdminUser(AdminUsersRequest request) throws ConflictException {
        AdminUser admin = adminUserRepository.getAdminUserByLogin(request.getLogin()).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден!"));
        ;
        if (admin == null) {
            throw new ConflictException("Пользователь не найден!");
        }
        if (!admin.getPassword().equals(request.getPassword())) {
            throw new ConflictException("Неверный пароль");
        }


        UserDetails userDetails = userDetailsService.loadUserByUsername(admin.getLogin());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        String token = tokenProvider.generateToken(authentication);

        refreshTokenService.deleteByUserPin(customUserDetails.getUsername());
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(customUserDetails.getUsername());

        return new JwtAuthenticationResponse(token, refreshToken.getToken());
    }
}
