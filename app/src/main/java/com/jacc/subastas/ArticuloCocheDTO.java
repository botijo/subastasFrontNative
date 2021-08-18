package com.jacc.subastas;

public class ArticuloCocheDTO {

    private String estado;
    private String expediente;
    private String fechaFin;
    private String horaFin;
    private String idSubasta;
    private String lugar;
    private String tipoFinca;
    private String ubicacionCoche;
    private String url;

    public ArticuloCocheDTO(){

    }

    public ArticuloCocheDTO(String estado, String expediente, String fechaFin, String horaFin, String idSubasta, String lugar, String tipoFinca, String ubicacionCoche, String url) {
        this.estado = estado;
        this.expediente = expediente;
        this.fechaFin = fechaFin;
        this.horaFin = horaFin;
        this.idSubasta = idSubasta;
        this.lugar = lugar;
        this.tipoFinca = tipoFinca;
        this.ubicacionCoche = ubicacionCoche;
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

    public String getUbicacionCoche() {
        return ubicacionCoche;
    }

    public void setUbicacionCoche(String ubicacionCoche) {
        this.ubicacionCoche = ubicacionCoche;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
