package com.addtech.admin.models;
import com.addtech.admin.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "admin_users")
@Getter
@Setter
public class AdminUser extends BaseModel{

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private UserRole role;
}
