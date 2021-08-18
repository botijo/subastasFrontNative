package com.jacc.subastas;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ArticuloCocheAdapter extends FirebaseRecyclerAdapter<ArticuloCocheDTO, ArticuloCocheAdapter.ViewHolder> {

    public ArticuloCocheAdapter(@NonNull FirebaseRecyclerOptions<ArticuloCocheDTO> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull ArticuloCocheDTO model) {

        holder.textViewIdSubasta.setText(model.getIdSubasta());
        holder.textViewTipoBien.setText("Vehiculo");
        holder.textViewTipoFinca.setText(model.getTipoFinca());
        holder.textViewFechaFin.setText(model.getFechaFin());
        enlace(holder.textViewUrl, model.getUrl());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_subasta_coches, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTipoBien;
        TextView textViewIdSubasta;
        TextView textViewTipoFinca;
        TextView textViewFechaFin;
        TextView textViewUrl;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
             textViewTipoBien = itemView.findViewById(R.id.textViewTipoBien);
             textViewIdSubasta = itemView.findViewById(R.id.textViewIdSubasta);
             textViewTipoFinca = itemView.findViewById(R.id.textViewTipoFinca);
             textViewFechaFin = itemView.findViewById(R.id.textViewFechaFin);
             textViewUrl = itemView.findViewById(R.id.textViewUrl);

        }
    }

    /**
     * Metodo que le da un alias a la dirección url del enlace
     * @param textViewUrl
     * @param dynamicUrl
     */
    private void enlace(TextView textViewUrl, String dynamicUrl){

        String linkedText = " Más información  " +
                String.format("<a href=\"%s\"><b>aquí</b></a> ", dynamicUrl);

        textViewUrl.setText(Html.fromHtml(linkedText));
        textViewUrl.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
