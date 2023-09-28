package com.example.todolist;

public class Note {
    private int id;
    private String name;
    private int priority;

    public Note(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public Note(int id, String name, int priority) {
        this.id = id;
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
