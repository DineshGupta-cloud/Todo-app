package com.todoapp.todo;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name="todos", indexes=@Index(name="idx_todos_created_at", columnList="created_at"))
public class Todo {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(nullable=false, length=200) private String title;
  @Column(nullable=false) private boolean completed;
  @Column(name="created_at", nullable=false, updatable=false) private Instant createdAt;
  @Column(name="updated_at", nullable=false) private Instant updatedAt;
  protected Todo() {}
  public Todo(String title) { this.title=title; }
  @PrePersist void prePersist(){ var now=Instant.now(); createdAt=now; updatedAt=now; }
  @PreUpdate void preUpdate(){ updatedAt=Instant.now(); }
  public Long getId(){return id;} public String getTitle(){return title;} public boolean isCompleted(){return completed;} public Instant getCreatedAt(){return createdAt;} public Instant getUpdatedAt(){return updatedAt;}
  public void update(String title, boolean completed){this.title=title;this.completed=completed;}
}