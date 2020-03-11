package com.example.pruebatodolist.repo;

import com.example.pruebatodolist.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository <TodoItem,Long> 
{

}
