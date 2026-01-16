package dev;

public record Todo(
        Long id,
        Long userId,
        String title,
        Boolean completed) {

}
