package com.addtech.admin.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class DocumentResponseById {
    private UUID id;
    private LocalDateTime createdAt;
    private String name;
    private String comment;
    private String status;
    private AttachmentResponse document;
    private List<SignatureResponse> signatures;
    private Boolean isOpenClosed;
    private List<DocumentShareResponse> documentShareInn;
}
