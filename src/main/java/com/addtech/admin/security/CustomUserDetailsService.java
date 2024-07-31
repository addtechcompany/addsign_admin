package com.addtech.admin.security;

import com.addtech.admin.models.AdminUser;
import com.addtech.admin.repositories.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminUserRepository adminUserRepository;

    @Autowired
    public CustomUserDetailsService(AdminUserRepository  adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AdminUser user = adminUserRepository.getAdminUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден!"));

        return new CustomUserDetails(user);
    }
}
