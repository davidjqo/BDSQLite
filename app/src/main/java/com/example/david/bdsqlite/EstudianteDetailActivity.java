package com.example.david.bdsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import entities.Estudiante;

public class EstudianteDetailActivity extends AppCompatActivity {

    private TextView textView_id, textView_nombre, textView_apellido, textView_edad;
    private Button buttonBack, buttonEdit, buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante_detail);
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

        Intent intent = getIntent();
        Estudiante estudiante = (Estudiante) intent.getSerializableExtra("estudiante");

        this.textView_id = (TextView) findViewById(R.id.textView_id);
        this.textView_id.setText(estudiante.getId());
        this.textView_nombre = (TextView) findViewById(R.id.textView_nombre);
        this.textView_nombre.setText(estudiante.getNombre());
        this.textView_apellido = (TextView) findViewById(R.id.textView_apellido);
        this.textView_apellido.setText(estudiante.getApellido());
        this.textView_edad = (TextView) findViewById(R.id.textView_edad);
        this.textView_edad.setText(String.valueOf(estudiante.getEdad()));

        //this.buttonBack = findViewById(R.id.buttonBack);
        /*this.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(EstudianteDetailActivity.this, ListViewEstudiantes.class);
                startActivity(intent1);
            }
        });*/
    }

}
