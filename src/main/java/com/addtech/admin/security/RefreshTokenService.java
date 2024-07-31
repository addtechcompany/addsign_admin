package com.addtech.admin.security;

import com.addtech.admin.exceptions.TokenRefreshException;
import com.addtech.admin.models.RefreshToken;
import com.addtech.admin.repositories.AdminUserRepository;
import com.addtech.admin.repositories.RefreshTokenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final AdminUserRepository userRepository;
    @Value("${app.jwt.token.refreshExpirationMs}")
    private Long refreshTokenDurationMs;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository, AdminUserRepository userRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
    }

    /**
     * поиск обновленного token
     *
     * @param token - обновленный token
     * @return - обновленный token
     */
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    /**
     * Создание обновленного token
     *
     * @param login - pin пользователя
     * @return - обновленный token
     */
    public RefreshToken createRefreshToken(String login) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUser(userRepository.getAdminUserByLogin(login).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    /**
     * Проверка token на истечение времени
     *
     * @param token - обновленный token
     * @return - обновленный token
     */
    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Срок действия токена обновления истек. Пожалуйста, отправьте новый запрос на вход");
        }

        return token;
    }

    /**
     * Удаление обновленного token
     *
     * @param login - pin пользователя
     */
    @Transactional
    public void deleteByUserPin(String login) {
        refreshTokenRepository.deleteByUser(userRepository.getAdminUserByLogin(login).get());
    }
}
