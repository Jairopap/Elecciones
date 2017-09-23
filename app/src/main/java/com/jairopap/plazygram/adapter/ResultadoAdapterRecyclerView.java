package com.jairopap.plazygram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jairopap.plazygram.R;
import com.jairopap.plazygram.model.Picturer;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by Jairo on 03/08/2017.
 */

public class ResultadoAdapterRecyclerView extends RecyclerView.Adapter<ResultadoAdapterRecyclerView.ResultadoViewHorder> {

    private ArrayList<Picturer> resultados;
    private int resource;
    private Activity activity;

    public ResultadoAdapterRecyclerView(ArrayList<Picturer> resultados, int resource, Activity activity) {

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
        Picturer picturer =resultados.get(position);

        holder.porcentaje_votos.setText(picturer.getVotos());
        holder.nombre_candidato.setText(picturer.getNombreC());
        holder.partido_politico.setText(picturer.getPartido());
        holder.progressBarra.setProgress(picturer.getProgressBarra());
        holder.progressBarra.setMax(100);
        Picasso.with(activity).load(picturer.getPicturer()).into(holder.imagen_candidato);
    }
    @Override
    public int getItemCount() {
        return resultados.size();
    }
    public class ResultadoViewHorder extends RecyclerView.ViewHolder {

        private ImageView imagen_candidato;
        private TextView porcentaje_votos;
        private TextView nombre_candidato;
        private TextView partido_politico;
        private ProgressBar progressBarra;

        public ResultadoViewHorder(View itemView) {
            super(itemView);

            imagen_candidato     = (ImageView) itemView.findViewById(R.id.imageC);
            progressBarra        = (ProgressBar) itemView.findViewById(R.id.progressBar);
            porcentaje_votos     = (TextView) itemView.findViewById(R.id.porcentaje_votos);
            nombre_candidato     = (TextView) itemView.findViewById(R.id.nombre_candidato);
            partido_politico     = (TextView) itemView.findViewById(R.id.partido_politico);
        }
    }

}
