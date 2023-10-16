package com.in48hours.springboot.startlearnapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in48hours.springboot.startlearnapp.models.Todo;

public interface TodoRepository  extends JpaRepository<Todo, Integer>{
	public List<Todo> findByUsername(String username);
}
