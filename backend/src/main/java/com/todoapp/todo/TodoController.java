package com.todoapp.todo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
@CrossOrigin(origins="${app.cors-origin:http://localhost:5173}")
public class TodoController {
  private final TodoRepository repo;
  public TodoController(TodoRepository repo){this.repo=repo;}
  record TodoRequest(@NotBlank @Size(max=200) String title, boolean completed) {}
  @GetMapping public List<Todo> list(){ return repo.findAll(); }
  @PostMapping @ResponseStatus(HttpStatus.CREATED) public Todo create(@Valid @RequestBody TodoRequest r){return repo.save(new Todo(r.title()));}
  @PutMapping("/{id}") public Todo update(@PathVariable Long id,@Valid @RequestBody TodoRequest r){var t=repo.findById(id).orElseThrow();t.update(r.title(),r.completed());return repo.save(t);}
  @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){repo.deleteById(id);}
}