package com.consorcio.pharmacy.dto;

public class ComunaDto {
    private int idRegion;
    private String nameComuna;

    public ComunaDto() {
    }

    public ComunaDto(int idRegion, String nameComuna) {
        this.idRegion = idRegion;
        this.nameComuna = nameComuna;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNameComuna() {
        return nameComuna;
    }

    public void setNameComuna(String nameComuna) {
        this.nameComuna = nameComuna;
    }
}
