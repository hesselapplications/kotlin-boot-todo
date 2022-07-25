package com.hessel.todo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "TODO_ITEM")
class TodoItem(

    @Id
    @Column(name = "TODO_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null,

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "TODO_LIST_ID")
    var list: TodoList,

    @Column(name = "DESCRIPTION")
    var description: String,

    @Type(type = "yes_no")
    @Column(name = "COMPLETE")
    var complete: Boolean)
