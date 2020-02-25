package com.example.m7proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class adalumnos extends AppCompatActivity {

    static final int MAX_NOTA = 10;
    static final int MIN_NOTA = 0;
    String [] array_nombres;
    int [] array_nota1;
    int [] array_nota2;
    int [] array_nota3;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adalumnos);

        Intent adddatos = getIntent();
        array_nombres = adddatos.getStringArrayExtra( "go_arraynombres");
        array_nota1 = adddatos.getIntArrayExtra( "go_arraynota1");
        array_nota2 = adddatos.getIntArrayExtra( "go_arraynota2");
        array_nota3 = adddatos.getIntArrayExtra( "go_arraynota3");
        contador = adddatos.getIntExtra( "go_contador",0);

        final Button guardado = findViewById(R.id.guardado_datos);
        guardado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText dato_nombre = findViewById(R.id.intro_nombre);
                String guardado_nombre = dato_nombre.getText().toString();

                EditText dato_nota1 = findViewById(R.id.intro_nota1);
                int guardado_nota1 = Integer.parseInt(dato_nota1.getText().toString());

                EditText dato_nota2 = findViewById(R.id.intro_nota1);
                int guardado_nota2 = Integer.parseInt(dato_nota2.getText().toString());

                EditText dato_nota3 = findViewById(R.id.intro_nota1);
                int guardado_nota3 = Integer.parseInt(dato_nota3.getText().toString());

                array_nombres[contador] = guardado_nombre;
                array_nota1[contador] = guardado_nota1;
                array_nota2[contador] = guardado_nota2;
                array_nota3[contador] = guardado_nota3;
            }
        });

        Intent returnIntent = new Intent();
        returnIntent.putExtra("go_arraynombres", array_nombres);
        returnIntent.putExtra("go_arraynota1", array_nota1);
        returnIntent.putExtra("go_arraynota2", array_nota2);
        returnIntent.putExtra("go_arraynota3", array_nota3);
        returnIntent.putExtra("go_contador", contador);
        setResult(RESULT_OK, returnIntent);

        TextView Texto = findViewById(R.id.comprobacion1);
        Texto.setText(array_nombres[contador]);
    }
}
