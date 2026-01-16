package dev;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "https://jsonplaceholder.typicode.com/", accept = "application/json")
public interface TodoService {

    @GetExchange("/todos")
    List<Todo> getAllTodos();

    @GetExchange("/todos/{id}")
    Todo getTodoById(@PathVariable Long id);

    @GetExchange("/todos?userId={userId}")
    List<Todo> getTodosByUserId(@PathVariable Long userId);

    @GetExchange("/todos")
    Todo createTodo(Todo todo);

    @GetExchange("/todos/{id}")
    Todo updateTodo(@PathVariable Long id, Todo todo);

    @GetExchange("/todos/{id}")
    void deleteTodo(@PathVariable Long id);
}
