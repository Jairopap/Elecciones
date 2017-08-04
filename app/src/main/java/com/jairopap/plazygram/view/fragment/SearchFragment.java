package com.jairopap.plazygram.view.fragment;


import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jairopap.plazygram.R;
import com.jairopap.plazygram.adapter.PictureAdapterRecyclerView;
import com.jairopap.plazygram.adapter.ResultadoAdapterRecyclerView;
import com.jairopap.plazygram.model.Picture;
import com.jairopap.plazygram.model.Resultado;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        showToolbar(getResources().getString(R.string.tab_search), false, view);

        RecyclerView resultadosRecycler = (RecyclerView) view.findViewById(R.id.resultadoRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        resultadosRecycler.setLayoutManager(linearLayoutManager);

        ResultadoAdapterRecyclerView pictureAdapterRecyclerView =
                new ResultadoAdapterRecyclerView(buildResultados(), R.layout.progresbar_card, getActivity());
        resultadosRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }
    public ArrayList<Resultado> buildResultados(){

        ArrayList<Resultado> resultados = new ArrayList<>();
        resultados.add(new Resultado("@drawable/tati",   "90", "60", "6566", "5645644"));
        return resultados;
    }

    private void showToolbar(String tittle, boolean upButton, View view) {
        Toolbar toolbar =(Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
