package com.addtech.admin.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class AttachmentResponse {
    private UUID id;
    private String name;
    private String type;
    private String md5Data;
    private byte[] data;
}
