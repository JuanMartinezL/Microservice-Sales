package com.microservice.Sales.infrastructure.clients;

import com.microservice.Sales.domain.external.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public User getUserById(Long userId) {
        return restTemplate.getForObject("http://localhost:8081/users/" + userId, User.class);
    }
}
