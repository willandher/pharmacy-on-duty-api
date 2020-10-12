package com.consorcio.pharmacy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PharmacyDto {
        private String nombreLocal;
        private String direccion;
        private String telefono;
        private String localLat;
        private String localLng;

    public PharmacyDto() {
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalLat() {
        return localLat;
    }

    public void setLocalLat(String localLat) {
        this.localLat = localLat;
    }

    public String getLocalLng() {
        return localLng;
    }

    public void setLocalLng(String localLng) {
        this.localLng = localLng;
    }
}
