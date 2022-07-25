package com.hessel.todo.controller

import com.hessel.todo.model.TodoItem
import com.hessel.todo.repository.TodoItemRepository
import com.hessel.todo.repository.TodoListRepository
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

@RestController
@Tag(name = "Items")
@RequestMapping("/lists/{listId}/items")
class TodoItemController(
    private val todoItemRepository: TodoItemRepository,
    private val todoListRepository: TodoListRepository) {

    @PostMapping
    @Operation(summary = "Create an item")
    fun createItem(@PathVariable listId: Long, @RequestParam description : String): TodoItem {
        val list = todoListRepository.findByIdOrNull(listId) ?: throw IllegalArgumentException("No list found with id: $listId")
        val item = TodoItem(
            description = description,
            list = list,
            complete = false)

        return todoItemRepository.save(item)
    }

    @PutMapping("/{itemId}/description")
    @Operation(summary = "Update the description of an item")
    fun updateItemDescription(@PathVariable itemId: Long, @RequestParam description: String): TodoItem {
        val item = todoItemRepository.findByIdOrNull(itemId) ?: throw IllegalArgumentException("No item found with id: $itemId")
        item.description = description
        return todoItemRepository.save(item)
    }

    @PutMapping("/{itemId}/complete")
    @Operation(summary = "Update the completion status of an item")
    fun updateItemComplete(@PathVariable itemId: Long, @RequestParam complete: Boolean): TodoItem {
        val item = todoItemRepository.findByIdOrNull(itemId) ?: throw IllegalArgumentException("No item found with id: $itemId")
        item.complete = complete
        return todoItemRepository.save(item)
    }

    @DeleteMapping("/{itemId}")
    @Operation(summary = "Delete an item")
    fun deleteItem(@PathVariable itemId: Long) {
        if (todoItemRepository.existsById(itemId)) {
            todoItemRepository.deleteById(itemId)
        }
    }

}