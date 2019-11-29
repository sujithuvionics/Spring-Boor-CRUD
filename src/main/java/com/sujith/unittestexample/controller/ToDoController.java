package com.sujith.unittestexample.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sujith.unittestexample.exception.ToDoException;
import com.sujith.unittestexample.model.Response;
import com.sujith.unittestexample.model.ToDo;
import com.sujith.unittestexample.service.ToDoService;
import com.sujith.unittestexample.util.PayloadValidator;

@RestController
public class ToDoController {

	private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

	@Autowired
	private ToDoService toDoService;

	@GetMapping("/todo")
	public ResponseEntity<List<ToDo>> getAllToDo() {
		logger.info("Returning all the ToDo´s");
		return new ResponseEntity<>(toDoService.getAllToDo(), HttpStatus.OK);
	}

	@GetMapping("/todo/{id}")
	public ResponseEntity<ToDo> getToDoById(@PathVariable("id") long id) throws ToDoException {
		logger.info("ToDo id to return {} " , id);
		ToDo toDo = toDoService.getToDoById(id);
		return new ResponseEntity<>(toDo, HttpStatus.OK);
	}

   @DeleteMapping("/todo/{id}")
	public ResponseEntity<Response> removeToDoById(@PathVariable("id") long id) throws ToDoException {
		logger.info("ToDo id to remove {} " , id);
		toDoService.removeToDo(id);
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(), "ToDo has been deleted"),
				HttpStatus.OK);
	}

	@PostMapping("/todo")
	public ResponseEntity<ToDo> saveToDo(@RequestBody ToDo toDo) throws ToDoException {
		logger.info("Payload to save {} ",  toDo);
		if (!PayloadValidator.validateCreatePayload(toDo)) {
			throw new ToDoException("Payload malformed, id must not be defined");
		}
		return new ResponseEntity<>(toDoService.saveToDo(toDo), HttpStatus.OK);
	}

	@PatchMapping("todo")
	public ResponseEntity<ToDo> updateToDo(@RequestBody ToDo toDo) throws ToDoException {
		logger.info("Payload to update {} " , toDo);
		return new ResponseEntity<>(toDoService.saveToDo(toDo), HttpStatus.OK);
	}

}
