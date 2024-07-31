package com.addtech.admin.services;

import com.addtech.admin.payload.response.DocumentResponse;
import com.addtech.admin.payload.response.DocumentResponseById;
import com.addtech.admin.payload.response.OrganizationResponses;
import com.addtech.admin.payload.response.UserResponse;

import java.util.UUID;

public interface IAddSignService {

    DocumentResponse getDocuments(int page, int limit, String order);
    DocumentResponseById getDocumentById(UUID documentId);
    UserResponse getUsers(int page, int size, String order);
    OrganizationResponses getOrganizations(int page, int limit, String order);
}
