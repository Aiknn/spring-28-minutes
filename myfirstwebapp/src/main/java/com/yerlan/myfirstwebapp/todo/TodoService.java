package com.yerlan.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "in 28 minutes", "Learn AWS",
        LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "in 28 minutes", "Learn DevOps",
        LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3, "in 28 minutes", "Learn Full Stack",
        LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUserName(String username){
        return todos;
    }
}
