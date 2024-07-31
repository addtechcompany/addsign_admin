package com.addtech.admin.services.impl;

import com.addtech.admin.payload.response.DocumentResponse;
import com.addtech.admin.payload.response.DocumentResponseById;
import com.addtech.admin.payload.response.OrganizationResponses;
import com.addtech.admin.payload.response.UserResponse;
import com.addtech.admin.services.IAddSignService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddSignService implements IAddSignService {


    private final RestTemplate restTemplate;

    @Value("${myApp.API_URL}")
    private String API_URL;
    @Override
    public DocumentResponse getDocuments(int page, int limit, String order) {
        String url = UriComponentsBuilder.fromHttpUrl(API_URL+"documents")
                .queryParam("page", page)
                .queryParam("limit", limit)
                .queryParam("order", order)
                .toUriString();
        return restTemplate.getForObject(url, DocumentResponse.class);
    }

    @Override
    public DocumentResponseById getDocumentById(UUID documentId) {

        return restTemplate.getForEntity(API_URL+"get/by/"+documentId, DocumentResponseById.class).getBody();
    }

    @Override
    public UserResponse getUsers(int page, int size, String order) {
        String url = UriComponentsBuilder.fromHttpUrl(API_URL+"users")
                .queryParam("page", page)
                .queryParam("size", size)
                .queryParam("order", order)
                .toUriString();
        return restTemplate.getForObject(url, UserResponse.class);
    }

    @Override
    public OrganizationResponses getOrganizations(int page, int limit, String order) {
        String url = UriComponentsBuilder.fromHttpUrl(API_URL+"organizations")
                .queryParam("page", page)
                .queryParam("limit", limit)
                .queryParam("order", order)
                .toUriString();
        return restTemplate.getForObject(url, OrganizationResponses.class);
    }

}
