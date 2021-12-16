package com.indra.models;

public class FormularioContacto {
    private String tituloAsunto;
    private String email;
    private String ordenReferencia;
    private String mensaje;
    private String archivoAdjunto;

    public String getTituloAsunto() {
        return tituloAsunto;
    }

    public String getEmail() {
        return email;
    }

    public String getOrdenReferencia() {
        return ordenReferencia;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getArchivoAdjunto() {
        return archivoAdjunto;
    }
}
