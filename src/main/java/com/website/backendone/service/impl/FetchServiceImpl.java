package com.website.backendone.service.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.website.backendone.model.User;
import com.website.backendone.service.FetchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FetchServiceImpl implements FetchService {
    @Value("${backend-two.api.url}")
    private String url;

    @Override
    public User validateToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> response = restTemplate.exchange(url + "/validate", HttpMethod.GET, requestEntity, User.class, 0);
        if (!response.getStatusCode().is2xxSuccessful())
            throw new RuntimeException("Invalid jwt");
        return response.getBody();
    }
}
