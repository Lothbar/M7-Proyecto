package com.example.m7proyecto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class inicio extends AppCompatActivity {

    static final int MAX_ALUMNOS = 50;
    String [] array_nombres = new String[MAX_ALUMNOS];
    int [] array_nota1 = new int [MAX_ALUMNOS];
    int [] array_nota2 = new int [MAX_ALUMNOS];
    int [] array_nota3 = new int [MAX_ALUMNOS];
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton boton_entre = findViewById(R.id.andeb);
        boton_entre.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                addalumnos();
            }
        });

        final ImageButton listado = findViewById(R.id.mostrab);
        listado.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                listalum();
            }
        });

        final ImageButton aprueba = findViewById(R.id.aprobadob);
        aprueba.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                aprobado_general();
            }
        });

        final ImageButton halp = findViewById(R.id.ayudab);
        halp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                hilp();
            }
        });
    }
    private void addalumnos(){
        Intent intent_introducir = new Intent(this, adalumnos.class);
        intent_introducir.putExtra("go_arraynombres", array_nombres);
        intent_introducir.putExtra("go_arraynota1",array_nota1);
        intent_introducir.putExtra("go_arraynota2", array_nota2);
        intent_introducir.putExtra("go_arraynota3", array_nota3);
        intent_introducir.putExtra("go_contador", contador);
        startActivityForResult(intent_introducir, 1);
    }

    private void listalum(){

        Intent intent_listar = new Intent(this, listaralumnos.class);
        intent_listar.putExtra("go_arraynombres", array_nombres);
        intent_listar.putExtra("go_arraynota1", array_nota1);
        intent_listar.putExtra("go_arraynota2", array_nota2);
        intent_listar.putExtra("go_arraynota3", array_nota3);
        intent_listar.putExtra("go_contador", contador);
        startActivity(intent_listar);

    }

    private void aprobado_general(){

        Intent intent_aprobado = new Intent(this, aprobado.class);
        intent_aprobado.putExtra("go_arraynota1",array_nota1);
        intent_aprobado.putExtra("go_arraynota2", array_nota2);
        intent_aprobado.putExtra("go_arraynota3", array_nota3);
        intent_aprobado.putExtra("go_contador", contador);
        startActivityForResult(intent_aprobado, 2);
    }

    private void hilp(){
        Intent intent_halp = new Intent( this, ayuda.class);
        startActivity(intent_halp);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                array_nombres = data.getStringArrayExtra("go_arraynombres");
                array_nota1 = data.getIntArrayExtra("array_nota1");
                array_nota2 = data.getIntArrayExtra("array_nota2");
                array_nota3 = data.getIntArrayExtra("array_nota3");
                contador = data.getIntExtra("go_contador", 0);

                TextView Texto = findViewById(R.id.prueba);
                Texto.setText(array_nombres[0]);
            }

            if(requestCode == 2){
                if (resultCode == RESULT_OK) {
                    array_nota1 = data.getIntArrayExtra("array_nota1");
                    array_nota2 = data.getIntArrayExtra("array_nota2");
                    array_nota3 = data.getIntArrayExtra("array_nota3");
                    contador = data.getIntExtra("go_contador", 0);
                }
            }
        }
    }
}
