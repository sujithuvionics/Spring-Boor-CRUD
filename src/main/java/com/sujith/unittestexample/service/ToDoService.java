package com.sujith.unittestexample.service;

import java.util.List;

import com.sujith.unittestexample.model.ToDo;

public interface ToDoService {
	public List<ToDo> getAllToDo();
	public ToDo getToDoById(long id);
	public ToDo saveToDo(ToDo todo);
	public void removeToDo(Long todo);
}
