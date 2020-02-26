package com.example.m7proyecto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    String [] array_nombres;
    int [] array_nota1;
    int [] array_nota2;
    int [] array_nota3;
    Context context;


    public RecyclerViewAdapter(Context con, String[] arrN/*,array_nota1,array_notan*/){
        array_nombres = arrN;
        context = con;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_parareclicler, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etiquetaNom.setText(array_nombres[position]);
    }

    @Override
    public int getItemCount() {
        return array_nombres.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView etiquetaNom;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.lista_recicler);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}