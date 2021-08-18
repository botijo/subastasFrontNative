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

public class ArticuloViviendaAdapter extends FirebaseRecyclerAdapter<ArticuloViviendaDTO, ArticuloViviendaAdapter.ViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ArticuloViviendaAdapter(@NonNull FirebaseRecyclerOptions<ArticuloViviendaDTO> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull ArticuloViviendaDTO model) {
        holder.textViewIdSubasta.setText(model.getIdSubasta());
        holder.textViewTipoBien.setText("Vivienda");
        holder.textViewTipoFinca.setText(model.getTipoFinca());
        holder.textViewFechaFin.setText(model.getFechaFin());
        holder.textViewExpediente.setText(model.getExpediente());
        holder.textViewHoraFin.setText(model.getHoraFin());
        holder.textViewLugar.setText(model.getLugar());
        holder.textViewUbicacion.setText(model.getUbicacionCasa());
        enlace(holder.textViewUrl, model.getUrl());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_subasta_viviendas, parent, false);
        return new ViewHolder(view);

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTipoBien;
        TextView textViewExpediente;
        TextView textViewIdSubasta;
        TextView textViewTipoFinca;
        TextView textViewFechaFin;
        TextView textViewLugar;
        TextView textViewHoraFin;
        TextView textViewUbicacion;
        TextView textViewUrl;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textViewTipoBien    = itemView.findViewById(R.id.textViewVTipoBien);
            textViewIdSubasta   = itemView.findViewById(R.id.textViewVIdSubasta);
            textViewTipoFinca   = itemView.findViewById(R.id.textViewVTipoFinca);
            textViewFechaFin    = itemView.findViewById(R.id.textViewVFechaFin);
            textViewExpediente  = itemView.findViewById(R.id.textViewVExpediente);
            textViewHoraFin     = itemView.findViewById(R.id.textViewVHoraFin);
            textViewLugar       = itemView.findViewById(R.id.textViewVLugar);
            textViewUbicacion   = itemView.findViewById(R.id.textViewVubicacionCasa);
            textViewUrl         = itemView.findViewById(R.id.textViewVUrl);

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
