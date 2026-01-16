package dev;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TodoService {

    private final RestClient restClient;

    public TodoService(RestClient.Builder builder) {
        restClient = builder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public List<Todo> findAll() {
        return restClient.get()
                .uri("/todos")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Todo>>() {
                });
    }

    public Todo findById(Long id) {
        return restClient.get()
                .uri("/todos/{id}", id)
                .retrieve()
                .body(Todo.class);
    }

}
