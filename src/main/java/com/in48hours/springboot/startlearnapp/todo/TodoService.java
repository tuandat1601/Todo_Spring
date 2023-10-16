package com.in48hours.springboot.startlearnapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.in48hours.springboot.startlearnapp.models.Todo;

import jakarta.validation.Valid;
@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList();
	private static int countId=0;
	static {
		todos.add(new Todo(++countId,"in48hours", "Learn 100 voca",
			 LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++countId,"ui", "Learn 100 voca",
				 LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++countId,"mo", "Learn 100 voca",
				 LocalDate.now().plusYears(1), false));
	}
	public List<Todo> findByUserName(String username){
		Predicate<? super Todo> predicate=todo ->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
 }
	public boolean addTodo(String username, String description,LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++countId, username, description, targetDate, done);
		if (todo!=null) {
			todos.add(todo);
			return true;
		}
		return false;
	}
	public void deleteItemById(int id) {
		Predicate<? super Todo> predicate
		=todo ->todo.getId()==id;
		todos.removeIf(predicate);
	}
	public Todo findById(int id) {
		Predicate<? super Todo> predicate=todo ->todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public void updateTodo(@Valid Todo todo) {
		deleteItemById(todo.getId());
		todos.add(todo);
	}
}
