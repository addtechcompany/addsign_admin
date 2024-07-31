package com.addtech.admin.models.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class StorageErrorDto {

    private String message;

}
