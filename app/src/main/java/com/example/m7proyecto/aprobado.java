package com.example.m7proyecto;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class aprobado extends AppCompatActivity {

    int [] array_nota1;
    int [] array_nota2;
    int [] array_nota3;
    int contador = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprobado);

        Intent aprobar = getIntent();
        array_nota1 = aprobar.getIntArrayExtra("go_arraynota1");
        array_nota2 = aprobar.getIntArrayExtra("go_arraynota2");
        array_nota3 = aprobar.getIntArrayExtra("go_arraynota3");
        contador = aprobar.getIntExtra( "go_contador", 0);

        final Button nunca = findViewById(R.id.no_tocar);
        nunca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0 ; i < contador - 1; i++){
                    array_nota1[i] = 5;
                    array_nota2[i] = 5;
                    array_nota3[i] = 5;
                }

                Intent notas_buenas = new Intent();
                notas_buenas.putExtra( "go_arraynota1", array_nota1);
                notas_buenas.putExtra( "go_arraynota2", array_nota2);
                notas_buenas.putExtra( "go_arraynota3", array_nota3);
                setResult(RESULT_OK, notas_buenas);

                TextView aprueban = findViewById(R.id.comprueba_nota);
                aprueban.setText(array_nota1[0]);
            }
        });
    }
}
