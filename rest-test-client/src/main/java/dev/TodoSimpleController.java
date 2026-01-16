package dev;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos/simple")
public class TodoSimpleController {

    @GetMapping("/")
    public List<Todo> findAll() {
        return List.of(new Todo(1L, 1L, "First Todo", true));
    }

    @GetMapping("/{id}")
    public Todo findAll(Long id) {
        return new Todo(1L, 1L, "First Todo", true);
    }

}
