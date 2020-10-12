package com.consorcio.pharmacy.controller;
import com.consorcio.pharmacy.dto.ComunaDto;
import com.consorcio.pharmacy.service.ComunaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

/**
 * Controlador de comunas
 */
@RestController
public class ComunaController {

    @Autowired
    ComunaServiceImpl comunaService;

    /**
     *
     * @return todas las comunas
     * @throws IOException
     */
    @GetMapping("/comunas")
    public List<ComunaDto> getComunas() throws IOException {
        return comunaService.allComunas();
    }

    /**
     * Valida la existencia de una comuna.
     * @param nameComuna comuna y id de la region donde pertenece
     * @return
     * @throws IOException
     */
    @GetMapping("/comunas/{nameComuna}")
    public  ComunaDto getComunaByName(@PathVariable  String nameComuna) throws IOException {
        return comunaService.findComunaByName(nameComuna);
    }


}
