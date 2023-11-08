package com.codewithbhargav.Spring.Controller;

import com.codewithbhargav.Spring.model.Todo;
import com.codewithbhargav.Spring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api")
public class todocontroller {
    @Autowired
    private TodoRepository todoRepository;
    @GetMapping("/todo/all")
    public List<Todo> gettodo(){
        return todoRepository.findall();

    }
@PostMapping("/todo")
    public List<Todo> addTodo(@RequestBody Todo todo){
        return todoRepository.insert(todo);
}
@PutMapping("/todo")
    public List<Todo> updatetodo(@RequestBody Todo todo){
        return todoRepository.update(todo);
}
@DeleteMapping("/todo/{id}")
    public List<Todo> deletetodo(@PathVariable int id){
        return todoRepository.deleteById(id);
}
}
