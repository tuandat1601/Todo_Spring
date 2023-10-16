package com.in48hours.springboot.startlearnapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in48hours.springboot.startlearnapp.models.Todo;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

@RequestMapping(value = "login-todo")
private String gotoToDo(ModelMap model) {
	String username = (String)model.get("name");
		List<Todo> todos = todoService.findByUserName(username);
		model.addAttribute("todo", todos);
	return "todo";
}
@RequestMapping( value="add-todo")
public String gotoPage( ModelMap model) {
		String username = (String)model.get("name");
		Todo todo = new Todo(0, username, "default item", LocalDate.now().plusYears(0), false);
		model.put("todo", todo);
		return "addtodo";
	}
@RequestMapping(value = "add-todo", method = RequestMethod.POST)
private String addToDo(ModelMap model, @Valid Todo todo, BindingResult result) {
	if(result.hasErrors()) {
		return "addtodo";
	}
		String username = (String)model.get("name");
		boolean add = todoService.addTodo(username,todo.getDescription(),todo.getTargetDate(), false);
		
	return "redirect:login-todo";
}
@RequestMapping(value = "delete-todo")
private String addToDo(@RequestParam int id) {
	todoService.deleteItemById(id);
	return "redirect:login-todo";
}
@RequestMapping(value = "update-todo",method = RequestMethod.GET)
private String updateTodoPage(@RequestParam int id,ModelMap model) {
	Todo todo = todoService.findById(id);
	model.addAttribute("todo",todo);
	return "addtodo";
}
@RequestMapping(value = "update-todo",method = RequestMethod.POST)
private String updateTodo( @Valid Todo todo,ModelMap model,BindingResult result) {
	if(result.hasErrors()) {
		return "addtodo";
	}
	String username = (String)model.get("name");
	todo.setUsername(username);
	todoService.updateTodo(todo);
	return "redirect:login-todo";
}
}
