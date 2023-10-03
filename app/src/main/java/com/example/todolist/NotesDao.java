package com.example.todolist;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


// класс для операция с базой
@Dao
public interface NotesDao {


    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void add(Note note);

    @Query("DELETE FROM notes WHERE id = :id")
    public void remove(int id);

}
