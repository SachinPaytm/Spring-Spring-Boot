package com.udemy.springboot.firstapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static long todoCount = 0;

    static {
        todos.add(new Todo(++todoCount, "sach", "Learn Spring", LocalDate.now().plusMonths(6), false));
        todos.add(new Todo(++todoCount, "sach", "Learn Spring Boot", LocalDate.now().plusMonths(5), false));
        todos.add(new Todo(++todoCount, "sach", "Learn Docker", LocalDate.now().plusMonths(4), false));
        todos.add(new Todo(++todoCount, "sach", "Learn Kubernetes", LocalDate.now().plusMonths(5), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = Todo -> Todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description,LocalDate targetDate, boolean done) {
        todos.add(new Todo(++todoCount,username,description,targetDate,done));
    }

    public void deleteTodoById(long id) {
        Predicate<? super Todo> predicate = Todo -> Todo.getId()==id;
        todos.removeIf(predicate);
    }

    public Todo findById(long id) {
        Predicate<? super Todo> predicate = Todo -> Todo.getId()==id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteTodoById(todo.getId());
        todos.add(todo);
    }
}
