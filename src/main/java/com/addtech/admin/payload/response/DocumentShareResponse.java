package com.addtech.admin.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class DocumentShareResponse {

    private String inn;
    private Boolean status;
    private UUID documentId;
}
