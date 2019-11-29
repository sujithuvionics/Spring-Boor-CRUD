package com.sujith.unittestexample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sujith.unittestexample.model.ToDo;
import com.sujith.unittestexample.repository.ToDoRepository;
import com.sujith.unittestexample.serviceimpl.ToDoServiceImpl;

@SpringBootTest
class UnitTestExampleApplicationTests {
	@Mock
	private ToDoRepository toDoRepository;
	@InjectMocks
	private ToDoServiceImpl toServiceImpl;

	@Test
	void saveToDo() {
		ToDo toDo = createToDo();
		when(toDoRepository.save(any(ToDo.class))).thenReturn(toDo);
		ToDo toDoData = toServiceImpl.saveToDo(toDo);
		assertEquals(toDo.getId(), toDoData.getId());
		assertEquals(toDo.getText(), toDoData.getText());
		assertEquals(toDo.isCompleted(), toDoData.isCompleted());
	}

	private ToDo createToDo() {
		return new ToDo(1, "sample to do", false);
	}

	@Test
	void findToDo() {
		ToDo toDo = createToDo();
		when(toDoRepository.findById(1l)).thenReturn(Optional.of(toDo));
		ToDo toDoData = toServiceImpl.getToDoById(1);
		assertEquals(toDo.getId(), toDoData.getId());
		assertEquals(toDo.getText(), toDoData.getText());
		assertEquals(toDo.isCompleted(), toDoData.isCompleted());
	}

}
