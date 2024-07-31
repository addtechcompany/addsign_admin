package com.addtech.admin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "balance_transactionals")
@Getter
@Setter
public class BalanceTransactional extends BaseModel{

    @Column(name = "org_id")
    private UUID organizationId;

    @Column(name = "summa_transfer")
    private double summaTransfer;

    @OneToMany
    @Column(name = "type_trans_id")
    List<TypeTransfer> typeTransfers;
}
