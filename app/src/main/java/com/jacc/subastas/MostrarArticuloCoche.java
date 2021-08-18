package com.jacc.subastas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MostrarArticuloCoche extends AppCompatActivity {

    RecyclerView recyclerViewVechiculos;
    ArticuloCocheAdapter adapterVehiculo;
    FirebaseDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_articulo_coche);

        recyclerViewVechiculos = findViewById(R.id.recycleVehiculos);
        recyclerViewVechiculos.setLayoutManager(new LinearLayoutManager(this));
        mDatabase = FirebaseDatabase.getInstance();

        Query query = mDatabase.getReference().child("subastasVehiculos").limitToLast(50);

        FirebaseRecyclerOptions<ArticuloCocheDTO> options =
                new FirebaseRecyclerOptions.Builder<ArticuloCocheDTO>()
                        .setQuery(query, ArticuloCocheDTO.class)
                        .build();

        adapterVehiculo = new ArticuloCocheAdapter(options);
        adapterVehiculo.notifyDataSetChanged();
        recyclerViewVechiculos.setAdapter(adapterVehiculo);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapterVehiculo.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterVehiculo.stopListening();
    }
}