package com.example.simplebookstore.authentication;

import org.springframework.stereotype.Service;

@Service
public class ApiKeyServiceImpl implements ApiKeyService{

    private final ApiKeyRepository apiKeyRepository;


    public ApiKeyServiceImpl(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    @Override
    public boolean isValidApiKey(String apiKey) {
        ApiKey foundKey = apiKeyRepository.findByApiKey(apiKey);
        System.out.println("foundKey"+foundKey);
        return foundKey != null;
    }
}
