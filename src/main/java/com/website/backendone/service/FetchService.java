package com.website.backendone.service;

import com.website.backendone.model.User;

public interface FetchService {
    User validateToken(String token);
}
