package com.jairopap.plazygram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jairopap.plazygram.R;
import com.jairopap.plazygram.model.Resultado;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Jairo on 03/08/2017.
 */

public class ResultadoAdapterRecyclerView extends RecyclerView.Adapter<ResultadoAdapterRecyclerView.ResultadoViewHorder> {

    private ArrayList<Resultado> resultados;
    private int resource;
    private Activity activity;

    public ResultadoAdapterRecyclerView(ArrayList<Resultado> resultados, int resource, Activity activity) {

        this.resultados = resultados;
        this.resource = resource;
        this.activity = activity;

    }

    @Override
    public ResultadoViewHorder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ResultadoViewHorder(view);
    }

    @Override
    public void onBindViewHolder(ResultadoViewHorder holder, int position) {
        Resultado resultado =resultados.get(position);

        holder.porcentaje_votos.setText(resultado.getPorcentaje_votos());
        holder.nombre_candidato.setText(resultado.getNombre_candidato());
        holder.partido_politico.setText(resultado.getPartido_politico());
        Picasso.with(activity).load(resultado.getResultado()).into(holder.imagen_candidato);



    }

    @Override
    public int getItemCount() {
        return resultados.size();
    }
    public class ResultadoViewHorder extends RecyclerView.ViewHolder {

        private ImageView imagen_candidato;
        private ProgressBar progressBar;
        private TextView porcentaje_votos;
        private TextView nombre_candidato;
        private TextView partido_politico;

        public ResultadoViewHorder(View itemView) {
            super(itemView);

            imagen_candidato     = (ImageView) itemView.findViewById(R.id.imagen_candidato);
            progressBar          = (ProgressBar) itemView.findViewById(R.id.progressBar);
            porcentaje_votos     = (TextView) itemView.findViewById(R.id.porcentaje_votos);
            nombre_candidato     = (TextView) itemView.findViewById(R.id.nombre_candidato);
            partido_politico     = (TextView) itemView.findViewById(R.id.partido_politico);
        }
    }

}
