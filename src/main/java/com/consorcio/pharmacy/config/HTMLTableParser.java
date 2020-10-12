package com.consorcio.pharmacy.config;
import com.consorcio.pharmacy.dto.ComunaDto;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import java.util.ArrayList;
import java.util.List;


/**
 * Dado que el servicio de comunas responde un html , se utilizo esta clase para recorrer y extraer información
 */
public class HTMLTableParser extends HTMLEditorKit.ParserCallback {

    private boolean encounteredATableOption = false;
    private List<ComunaDto> comunaDtoList = new ArrayList<>();
    private int idRegion;

    public HTMLTableParser() {
    }

    public HTMLTableParser(boolean encounteredATableOption, List<ComunaDto> comunaDtoList,int idRegion) {
        this.encounteredATableOption = encounteredATableOption;
        this.comunaDtoList = comunaDtoList;
        this.idRegion = idRegion;
    }

    public HTMLTableParser(int idRegion) {
        this.idRegion = idRegion;
    }

    public void handleText(char[] data, int pos) {
        if(encounteredATableOption) comunaDtoList.add(new ComunaDto(this.idRegion,new String(data)));
    }

    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        if(t == HTML.Tag.OPTION) encounteredATableOption = true;
    }

    public void handleEndTag(HTML.Tag t, int pos) {
        if(t == HTML.Tag.TR) encounteredATableOption = false;
    }

    public boolean isEncounteredATableOption() {
        return encounteredATableOption;
    }

    public void setEncounteredATableOption(boolean encounteredATableOption) {
        this.encounteredATableOption = encounteredATableOption;
    }

    public List<ComunaDto> getComunaDtoList() {
        return comunaDtoList;
    }

    public void setComunaDtoList(List<ComunaDto> comunaDtoList) {
        this.comunaDtoList = comunaDtoList;
    }
}