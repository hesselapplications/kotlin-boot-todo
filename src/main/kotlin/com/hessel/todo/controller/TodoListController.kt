package com.hessel.todo.controller

import com.hessel.todo.model.TodoList
import com.hessel.todo.repository.TodoListRepository
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

@RestController
@Tag(name = "Lists")
@RequestMapping("/lists")
class TodoListController(private val todoListRepository: TodoListRepository) {

    @PostMapping
    @Operation(summary = "Create a list")
    fun createList(@RequestParam name : String): TodoList {
        val list = TodoList(name = name)
        return todoListRepository.save(list)
    }

    @GetMapping
    @Operation(summary = "Get all lists")
    fun getLists(): List<TodoList> {
        return todoListRepository.findAll()
    }

    @PutMapping("/{listId}/name")
    @Operation(summary = "Update the name of a list")
    fun updateListName(@PathVariable listId: Long, @RequestParam name : String): TodoList {
        val list = todoListRepository.findByIdOrNull(listId) ?: throw IllegalArgumentException("No list found with id: $listId")
        list.name = name
        return todoListRepository.save(list)
    }

    @DeleteMapping("/{listId}")
    @Operation(summary = "Delete a list")
    fun deleteList(@PathVariable listId: Long) {
        if (todoListRepository.existsById(listId)) {
            todoListRepository.deleteById(listId)
        }
    }

}