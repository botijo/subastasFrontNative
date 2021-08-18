package com.jacc.subastas;

public class ArticuloViviendaDTO {

    private String estado;
    private String expediente;
    private String fechaFin;
    private String horaFin;
    private String idSubasta;
    private String lugar;
    private String tipoFinca;
    private String ubicacionCasa;
    private String url;

    public ArticuloViviendaDTO(){

    }

    public ArticuloViviendaDTO(String estado, String expediente, String fechaFin, String horaFin, String idSubasta, String lugar, String tipoFinca, String ubicacionCasa, String url) {
        this.estado = estado;
        this.expediente = expediente;
        this.fechaFin = fechaFin;
        this.horaFin = horaFin;
        this.idSubasta = idSubasta;
        this.lugar = lugar;
        this.tipoFinca = tipoFinca;
        this.ubicacionCasa = ubicacionCasa;
        this.url = url;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getIdSubasta() {
        return idSubasta;
    }

    public void setIdSubasta(String idSubasta) {
        this.idSubasta = idSubasta;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getTipoFinca() {
        return tipoFinca;
    }

    public void setTipoFinca(String tipoFinca) {
        this.tipoFinca = tipoFinca;
    }

    public String getUbicacionCasa() {
        return ubicacionCasa;
    }

    public void setUbicacionCasa(String ubicacionCasa) {
        this.ubicacionCasa = ubicacionCasa;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
