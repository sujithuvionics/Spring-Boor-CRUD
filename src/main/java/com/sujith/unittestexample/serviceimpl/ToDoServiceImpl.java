package com.sujith.unittestexample.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujith.unittestexample.model.ToDo;
import com.sujith.unittestexample.repository.ToDoRepository;
import com.sujith.unittestexample.service.ToDoService;

@Service("toDoService")
public class ToDoServiceImpl implements ToDoService{

	@Autowired
	private ToDoRepository toDoRepository;
	
	@Override
	public List<ToDo> getAllToDo() {
		return toDoRepository.findAll();
	}

	@Override
	public Optional<ToDo> getToDoById(long id) {
		return toDoRepository.findById(id);
	}

	@Override
	public ToDo saveToDo(ToDo todo) {
		return toDoRepository.save(todo);
	}

	@Override
	public void removeToDo(ToDo todo) {
		toDoRepository.delete(todo);
	}
	

}
