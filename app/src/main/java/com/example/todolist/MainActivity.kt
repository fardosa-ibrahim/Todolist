package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdaptor:TodoAdaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdaptor=TodoAdaptor(mutableListOf())
        rvTodoItems.adapter=todoAdaptor
        rvTodoItems.layoutManager=LinearLayoutManager(this)
        btnAddTodo.setOnClickListener {
            val todoTitle=etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()){
                val todo=Todo(todoTitle)
                todoAdaptor.adding(todo)
                etTodoTitle.text.clear()
            }
        }
        btnDeleteDoneTodos.setOnClickListener {
            todoAdaptor.deleteTodos()
        }

    }
}