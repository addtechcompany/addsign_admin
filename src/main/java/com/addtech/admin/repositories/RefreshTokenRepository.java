package com.addtech.admin.repositories;

import com.addtech.admin.models.AdminUser;
import com.addtech.admin.models.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {
    Optional<RefreshToken> findByToken(String token);

    @Query("delete from refresh_token r where r.user = ?1")
    @Transactional
    @Modifying
    void deleteByUser(AdminUser user);
}