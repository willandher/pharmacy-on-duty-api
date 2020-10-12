package com.consorcio.pharmacy.controller;
import com.consorcio.pharmacy.dto.ComunaDto;
import com.consorcio.pharmacy.service.IPharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;


/**
 *
 */
@RestController
public class LocalController {

    @Autowired
    IPharmacyService pharmacyService;

    /**
     *
     * @param comuna
     * @param idRegion
     * @return
     * @throws IOException
     */
    @GetMapping("/localByComuna")
    public List<String> getLocalesPorComuna(@RequestParam String comuna, @RequestParam String idRegion) throws IOException {
        return pharmacyService.getLocalByComuna(comuna,idRegion);
    }


    @GetMapping("/locales")
    public List<String> getLocales() throws IOException {
        return pharmacyService.getLocales();
    }



}
