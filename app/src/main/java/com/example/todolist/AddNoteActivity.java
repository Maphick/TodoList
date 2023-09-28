package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextNote;
    private RadioButton radioButtonLow;
    private RadioButton radioButtonMedium;
    private Button buttonSave;

    private DataBase dataBase = DataBase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        initViews();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });

    }

    private void initViews()
    {
        editTextNote = findViewById(R.id.editTextNote);
        radioButtonLow = findViewById(R.id.radioButtonLow);
        radioButtonMedium = findViewById(R.id.radioButtonMedium);
        buttonSave = findViewById(R.id.buttonSave);
    }

    private void saveNote()
    {
        String text = editTextNote.getText().toString().trim();
        int priority = getPriority();
        Note note = new Note(text, priority);
        DataBase dataBase = DataBase.getInstance();
        dataBase.add(note);

        finish();
    }

    private int getPriority()
    {
        if (radioButtonLow.isChecked())
        {
            return 0;
        }
        else if (radioButtonMedium.isChecked())
        {
            return 1;
        }
        else return 2;
    }

    // Ctrl - показать все вызовы экрана во всём проекте
    // фабричный метод
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, AddNoteActivity.class);
        return intent;
    }

}