package com.example.simplebookstore.authentication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiKeyRepository extends JpaRepository<ApiKey,Long> {
    ApiKey findByApiKey(String apiKey);
}
