package dev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.servlet.client.RestTestClient;

public class TodoControllerMockTests {
    RestTestClient client;
    TodoService todoService;

    @BeforeEach
    void setUp() {
        // mock todoService
        todoService = Mockito.mock(TodoService.class);
        Mockito.when(todoService.findAll()).thenReturn(List.of(new Todo(1L, 1L, "First Todo", true)));

        client = RestTestClient.bindToController(new TodoController(todoService)).build();
    }

    @Test
    void testFindAll() {
        List<Todo> todos = client.get()
                .uri("/api/todos/")
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<Todo>>() {
                })
                .returnResult()
                .getResponseBody();

        assertEquals(1, todos.size());
        assertEquals("First Todo", todos.get(0).title());
    }
}
