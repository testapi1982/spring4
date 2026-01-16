package dev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.servlet.client.RestTestClient;

public class TodoSimpleControllerTests {

    private RestTestClient client;

    @BeforeEach
    void setUp() {
        client = RestTestClient.bindToController(new TodoSimpleController()).build();
    }

    @Test
    void testFindAll() {
        List<Todo> todos = client.get()
                .uri("/api/todos/simple/")
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<Todo>>() {
                })
                .returnResult()
                .getResponseBody();

        assertEquals(1, todos.size());
        assertEquals("First Todo", todos.get(0).title());

    }

    @Test
    void testFindAll2() {
        Todo todo = new Todo(1L, 1L, "First Todo", true);
        client.get()
                .uri("/api/todos/simple/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Todo.class)
                .isEqualTo(todo)
                .value(t -> {
                    assertEquals(1L, t.id());
                    assertEquals(1L, t.userId());
                    assertEquals("First Todo", t.title());
                    assertEquals(true, t.completed());
                });

    }
}
