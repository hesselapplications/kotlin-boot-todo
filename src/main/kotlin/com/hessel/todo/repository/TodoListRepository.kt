package com.hessel.todo.repository

import com.hessel.todo.model.TodoItem
import com.hessel.todo.model.TodoList
import org.springframework.data.repository.CrudRepository

interface TodoListRepository : CrudRepository<TodoList, Long> {

    override fun findAll(): List<TodoList>

}