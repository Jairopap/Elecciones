package com.jairopap.plazygram.model;

/**
 * Created by Administrador on 03/08/2017.
 */

public class Resultado {

    private String resultado;
    private String progressBar;
    private String porcentaje_votos;
    private String nombre_candidato;
    private String partido_politico;



    public Resultado(String resultado, String progressBar, String porcentaje_votos, String nombre_candidato, String partido_politico) {

        this.resultado =resultado;

        this.progressBar = progressBar;
        this.porcentaje_votos = porcentaje_votos;
        this.porcentaje_votos = nombre_candidato;
        this.nombre_candidato = partido_politico;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }


    public String getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(String progressBar) {
        this.progressBar = progressBar;
    }

    public String getPorcentaje_votos() {
        return porcentaje_votos;
    }

    public void setPorcentaje_votos(String porcentaje_votos) {
        this.porcentaje_votos = porcentaje_votos;
    }

    public String getNombre_candidato() {
        return nombre_candidato;
    }

    public void setNombre_candidato(String nombre_candidato) {
        this.nombre_candidato = nombre_candidato;
    }

    public String getPartido_politico() {
        return partido_politico;
    }

    public void setPartido_politico(String partido_politico) {
        this.partido_politico = partido_politico;
    }


}

