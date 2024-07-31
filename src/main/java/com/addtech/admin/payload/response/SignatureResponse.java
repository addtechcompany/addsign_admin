package com.addtech.admin.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
public class SignatureResponse {
    private UUID id;
    private LocalDateTime createdAt;
    private String pin;
    private String fullName;
    private String cms;
    private AttachmentResponse certificate;
    private String content;
    private String fileName;
    private String type;
    private String organizationName;
}
