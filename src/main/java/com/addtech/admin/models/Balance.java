package com.addtech.admin.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "balances")
@Getter
@Setter
public class Balance extends BaseModel{

    @JoinColumn(name = "current_balance")
    private double currentBalance;
    @JoinColumn(name = "organiztion_id")
    private UUID organizationId;
}
