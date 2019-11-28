package com.sujith.unittestexample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sujith.unittestexample.model.ToDo;
import com.sujith.unittestexample.repository.ToDoRepository;
import com.sujith.unittestexample.service.ToDoService;
import com.sujith.unittestexample.serviceimpl.ToDoServiceImpl;

@SpringBootTest
class UnitTestExampleApplicationTests {
	@Mock
	private ToDoRepository toDoRepository;
	@InjectMocks
	private ToDoServiceImpl toServiceImpl;

	@Test
	void contextLoads() {
		ToDo toDo = new ToDo(1, "sample to do", false);
		when(toDoRepository.save(any(ToDo.class))).thenReturn(toDo);
		ToDo saveToDo = toServiceImpl.saveToDo(toDo);
		assertEquals(toDo.getId(), saveToDo.getId());
		assertEquals(toDo.getText(), saveToDo.getText());
		assertEquals(toDo.isCompleted(), saveToDo.isCompleted());
	}

}
