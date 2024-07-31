package com.addtech.admin.controllers;

import com.addtech.admin.payload.response.DocumentResponse;
import com.addtech.admin.payload.response.DocumentResponseById;
import com.addtech.admin.payload.response.OrganizationResponses;
import com.addtech.admin.payload.response.UserResponse;
import com.addtech.admin.services.IAddSignService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/addSign")
@RequiredArgsConstructor
public class AddSignController {

    private final IAddSignService addSignService;

    @GetMapping
    @Operation(summary = "Получить документы", description = "Получить все документы")
    public DocumentResponse getDocuments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "ASC") String order) {
        return addSignService.getDocuments(page, limit, order);
    }
    @GetMapping("/document/{documentId}")
    @Operation(summary = "Получить документ", description = "Получить документ по идентификатором")
    public DocumentResponseById getDocumentById(@PathVariable UUID documentId){
        return addSignService.getDocumentById(documentId);
    }

    @GetMapping("/users")
    @Operation(summary = "Получить пользователи", description = "Получить все пользователи")
    public UserResponse getDataList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") String order) {
       return addSignService.getUsers(page, size,order);
    }

    @GetMapping("/organizations")
    @Operation(summary = "Получить организации", description = "Получить все организации")
    public OrganizationResponses getOrganizations(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "ASC") String order) {
        return addSignService.getOrganizations(page, limit,order);
    }
}
