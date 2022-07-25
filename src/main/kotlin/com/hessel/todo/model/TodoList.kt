package com.hessel.todo.model

import javax.persistence.*

@Entity
@Table(name = "TODO_LIST")
class TodoList(

    @Id
    @Column(name = "TODO_LIST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null,

    @Column(name = "NAME")
    var name: String,

    @OneToMany(mappedBy = "list")
    var items: MutableList<TodoItem>?=ArrayList())
