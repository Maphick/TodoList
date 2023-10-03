package com.example.todolist;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private NoteDatabase noteDatabase;

    public LiveData<List<Note>> getNodes()
    {
        return noteDatabase.notesDao().getNotes();
    }
    public MainViewModel(Application application)
    {
        super(application);
        noteDatabase = NoteDatabase.getInstance(application);
    }


    public void remove(Note note)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                noteDatabase.notesDao().remove(note.getId());
            }
        }){
        };
        thread.start();

    }

}
