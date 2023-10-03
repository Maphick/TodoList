package com.example.todolist;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "notes")
public class Note {

    @PrimaryKey(autoGenerate = true)
    public int id;
    private String name;
    private int priority;


    @Ignore
    public Note(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public Note(String name, int priority) {
        this.id = 0;
        this.name = name;
        this.priority = priority;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}
