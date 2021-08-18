package com.jacc.subastas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MostrarArticuloVivienda extends AppCompatActivity {

    RecyclerView recyclerViewVivienda;
    ArticuloViviendaAdapter adapterVivienda;
    FirebaseDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_articulo_vivienda);

        recyclerViewVivienda = findViewById(R.id.recycleViviendas);
        recyclerViewVivienda.setLayoutManager(new LinearLayoutManager(this));
        mDatabase = FirebaseDatabase.getInstance();

        Query query = mDatabase.getReference().child("subastasViviendas").limitToLast(50);

        FirebaseRecyclerOptions<ArticuloViviendaDTO> options =
                new FirebaseRecyclerOptions.Builder<ArticuloViviendaDTO>()
                        .setQuery(query, ArticuloViviendaDTO.class)
                        .build();

        adapterVivienda = new ArticuloViviendaAdapter(options);
        adapterVivienda.notifyDataSetChanged();
        recyclerViewVivienda.setAdapter(adapterVivienda);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapterVivienda.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterVivienda.stopListening();
    }
}