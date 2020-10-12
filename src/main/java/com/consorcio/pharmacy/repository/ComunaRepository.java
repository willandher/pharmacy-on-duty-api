package com.consorcio.pharmacy.repository;


import com.consorcio.pharmacy.config.ApiRestComunaConfig;
import com.consorcio.pharmacy.config.HTMLTableParser;
import com.consorcio.pharmacy.dto.ComunaDto;
import com.consorcio.pharmacy.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


@Repository
public class ComunaRepository implements IMapperByService{
    @Autowired
    ApiRestComunaConfig configProperties;

    @Autowired
    RestTemplate restTemplate;

    private LinkedHashMap<Integer, List<ComunaDto>> comunas = new LinkedHashMap<>();

    private List<ComunaDto> comunaDtos = new ArrayList<>();

    /**
     * Se cargan todas comunas por medio de un componente en una lista
     * @throws IOException
     */
    @Bean(name = "mapperServiceComuna")
    public void mapperByService() throws IOException {
        String response;
        HttpHeaders headers =  new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        for(int i: configProperties.getRegionId()){
            for(String parameter :configProperties.getParameters()) {
                map.add(parameter, i);
            }
            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
            response = restTemplate.postForObject(configProperties.getApi(), requestEntity, String.class);
            Reader reader = new StringReader(response);
            HTMLEditorKit.Parser parser = new ParserDelegator();
            HTMLTableParser htmlTableParser = new HTMLTableParser(i);
            parser.parse(reader, htmlTableParser, true);
            comunas.put(i,htmlTableParser.getComunaDtoList());
            comunaDtos.addAll(htmlTableParser.getComunaDtoList());
        }

    }


    /**
     * busca todas las comunas
     * @return lista de comunas
     */
    public List<ComunaDto> getAllComunas() {
        return comunaDtos;
    }

    /**
     * Busca comuna por nombre
     * @param nameComuna
     * @return comuna
     */
    public ComunaDto findComunaByName(String nameComuna){
        return  this.comunaDtos.stream()
                .filter(a -> a.getNameComuna().equalsIgnoreCase(nameComuna.toUpperCase())).
                        findFirst().orElse(null);
    }
}
