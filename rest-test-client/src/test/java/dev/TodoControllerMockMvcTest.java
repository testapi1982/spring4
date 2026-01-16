package dev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.client.RestTestClient;

@WebMvcTest(TodoController.class)
public class TodoControllerMockMvcTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    TodoService todoService;

    RestTestClient client;

    @BeforeEach
    void setUp() {
        client = RestTestClient.bindTo(mockMvc).build();
    }

    @Test
    void findAllTodos() {
        Mockito.when(todoService.findAll()).thenReturn(
                List.of(new Todo(1L, 1L, "First Todo", true)));

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

    @Test
    void shouldValidateInput() {
        // RestTestClient client = RestTestClient.bindTo(mockMvc).build();

        client.post().uri("/api/todos/")
                .body(new Todo(null, null, "", false))
                .exchange()
                .expectStatus().is4xxClientError();

    }

}
