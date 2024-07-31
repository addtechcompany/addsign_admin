package com.addtech.admin.repositories;

import com.addtech.admin.models.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdminUserRepository extends JpaRepository<AdminUser, UUID> {

    Optional<AdminUser> getAdminUserByLogin(String login);
}