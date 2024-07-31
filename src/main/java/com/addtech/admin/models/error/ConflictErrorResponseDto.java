package com.addtech.admin.models.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConflictErrorResponseDto {
    private String message;
}
