package com.addtech.admin.models;

import com.addtech.admin.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "type_transfer")
@Getter
@Setter
public class TypeTransfer extends BaseModel{

    @Column(name = "type")
    private Type type;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private int code;
}
