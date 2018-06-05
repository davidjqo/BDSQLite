package com.example.david.bdsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import adapters.EstudianteListAdapter;
import database.EstudianteDB;
import entities.Estudiante;

public class ListViewEstudiantes extends AppCompatActivity {
    private ListView listViewEstudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_estudiantes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final EstudianteDB estudianteDB = new EstudianteDB(this);
        this.listViewEstudiantes = findViewById(R.id.listViewEstudiantes);
        this.listViewEstudiantes.setAdapter(new EstudianteListAdapter(this, estudianteDB.findAll()));
        this.listViewEstudiantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Estudiante estudiante = estudianteDB.findAll().get(position);
                Intent intent1 = new Intent(ListViewEstudiantes.this, EstudianteDetailActivity.class);
                intent1.putExtra("estudiante", estudiante);
                startActivity(intent1);
            }
        });
    }

}
