package com.hitandroid.appnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Database database;
    RecyclerView rcvNote;
    List<Note> arrNote;
    NoteAdapter noteAdapter;
    RelativeLayout add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rcvNote = findViewById(R.id.rcv_note);
        arrNote = new ArrayList<>();


        // Create Database Note
        database = new Database(this, "Note.sqlite", null, 1);
//
//        // Create table NOTE
        database.QueryData("CREATE TABLE IF NOT EXISTS NOTE(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR)");

        GetData();

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWork();
            }
        });
    }

    public void addWork() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_note);

        EditText editText = dialog.findViewById(R.id.textAdd);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        Button btnCancelAdd = dialog.findViewById(R.id.btnCancelAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                if (name.equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter your note", Toast.LENGTH_SHORT).show();
                } else {
                    database.QueryData("INSERT INTO NOTE VALUES(null, '" + name + "')");
                    Toast.makeText(MainActivity.this, "Added ", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    GetData();
                }
            }
        });


        btnCancelAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void UpdateNote(String name, int id) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.update_note);

        EditText textUpdate = dialog.findViewById(R.id.textUpdate);
        Button btnUpdate = dialog.findViewById(R.id.btnUpdate);
        Button btnCancelUpdate = dialog.findViewById(R.id.btnCancelUpdate);
        textUpdate.setText(name);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameNew = textUpdate.getText().toString().trim();
                database.QueryData("UPDATE NOTE SET name = '"+nameNew+"' WHERE id='"+id+"'");
                Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                GetData();
            }
        });


        btnCancelUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void DeleteNote(String name, int id) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.delete_note);

        TextView textDelete = dialog.findViewById(R.id.textDelete);
        Button btnSubmitDelete = dialog.findViewById(R.id.btnSubmitDelete);
        Button btnCancelDelete = dialog.findViewById(R.id.btnCancelDelete);
        textDelete.setText("Do you want to delete " + name + "?");

        btnSubmitDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.QueryData("DELETE FROM NOTE WHERE Id ='"+id+"'");
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                GetData();
            }
        });


        btnCancelDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void GetData() {
        Cursor dataNote = database.GetData("SELECT * From NOTE");
        arrNote.clear();
        while (dataNote.moveToNext()) {
            String name = dataNote.getString(1);
            int id = dataNote.getInt(0);
            arrNote.add(new Note(id, name));
        }
        noteAdapter = new NoteAdapter(this, arrNote);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvNote.setAdapter(noteAdapter);
        rcvNote.setLayoutManager(linearLayoutManager);
    }
}