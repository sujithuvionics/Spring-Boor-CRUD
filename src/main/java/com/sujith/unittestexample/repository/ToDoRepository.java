package com.sujith.unittestexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sujith.unittestexample.model.ToDo;

@Repository("toDoRepository")
public interface ToDoRepository extends JpaRepository<ToDo, Long>{

}
