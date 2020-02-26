package com.example.m7proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class listaralumnos extends AppCompatActivity {

    String [] array_nombres;
    int [] array_nota1;
    int [] array_nota2;
    int [] array_nota3;
    int contador;
    String cadena_nombres="";
    String cadena_nota1="";
    String cadena_nota2="";
    String cadena_nota3="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaralumnos);

        String [] array_nombres;
        int [] array_nota1;
        int [] array_nota2;
        int [] array_nota3;
        int contador;
        String cadena_nombres="";
        String cadena_nota1="";
        String cadena_nota2="";
        String cadena_nota3="";

        Intent recibedatos = getIntent();
        array_nombres = recibedatos.getStringArrayExtra("go_arraynombres");
        array_nota1 = recibedatos.getIntArrayExtra("go_arraynota1" );
        array_nota2 = recibedatos.getIntArrayExtra( "go_arraynota2");
        array_nota3 = recibedatos.getIntArrayExtra( "go_arraynota3");
        contador = recibedatos.getIntExtra( "go_contador", 0);

        RecyclerView recyclerView = findViewById(R.id.reclicler_lista);    /*si queremos añadir mas datos al reciclerview solo tendremos que: */
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, array_nombres/*,array_nota1,array_notan*/);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));

        TextView resultado = findViewById(R.id.nombres_lista);
        for (int i = 0 ; i < contador ; i++) {
            cadena_nombres = cadena_nombres + array_nombres[i];
        }
        TextView resultado1 = findViewById(R.id.nota1_lista);
        for (int i = 0 ; i < contador ; i++) {
            cadena_nota1 = cadena_nota1 + array_nota1[i];
        }
        TextView resultado2 = findViewById(R.id.nota2_lista);
        for (int i = 0 ; i < contador ; i++) {
            cadena_nota2 = cadena_nota2 + array_nota2[i];
        }
        TextView resultado3 = findViewById(R.id.nota3_lista);
        for (int i = 0 ; i < contador ; i++){
            cadena_nota3 = cadena_nota3+array_nota3[i];
        }
        resultado.setText(cadena_nombres);
        resultado1.setText(cadena_nota1);
        resultado2.setText(cadena_nota2);
        resultado3.setText(cadena_nota3);

    }
}
