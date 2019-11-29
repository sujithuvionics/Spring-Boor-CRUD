package com.sujith.unittestexample.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujith.unittestexample.exception.ToDoException;
import com.sujith.unittestexample.model.ToDo;
import com.sujith.unittestexample.repository.ToDoRepository;
import com.sujith.unittestexample.service.ToDoService;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;

	@Override
	public List<ToDo> getAllToDo() {
		return toDoRepository.findAll();
	}

	@Override
	public ToDo getToDoById(long id) {
		return toDoRepository.findById(id).orElseThrow(() -> new ToDoException("ToDo doesn´t exist"));
	}

	@Override
	public ToDo saveToDo(ToDo todo) {
		return toDoRepository.save(todo);
	}

	@Override
	public void removeToDo(Long todo) {
		toDoRepository.findById(todo).orElseThrow(() -> new ToDoException("ToDo to delete doesn´t exist"));
		toDoRepository.deleteById(todo);
	}

}
