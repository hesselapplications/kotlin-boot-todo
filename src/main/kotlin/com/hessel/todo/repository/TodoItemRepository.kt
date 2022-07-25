package com.hessel.todo.repository

import com.hessel.todo.model.TodoItem
import org.springframework.data.repository.CrudRepository

interface TodoItemRepository : CrudRepository<TodoItem, Long> {

}