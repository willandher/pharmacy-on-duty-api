package com.consorcio.pharmacy.controller;
import com.consorcio.pharmacy.dto.PharmacyDto;
import com.consorcio.pharmacy.service.IPharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;


@RestController
public class PharmacyController {

    @Autowired
    IPharmacyService pharmacyService;

    /**
     * Busca todas las farmacias en una region
     * @param idRegion
     * @return
     * @throws IOException
     */
    @GetMapping("/pharmacies/{idRegion}")
    public List<PharmacyDto> getPharmacies(@PathVariable String idRegion) throws IOException {
        return pharmacyService.getPharmacyByIdRegion(idRegion);
    }

    /**
     * Retorna todas las farmacias de turno en una comuna
     * @param comuna comuna donde buscaremos los locales
     * @param localNombre local a buscar
     * @param request
     * @return
     * @throws IOException
     */
    @GetMapping("/pharmaciesOnDuty")
    public List<PharmacyDto> getPharmaciesOnDuty(@RequestParam String comuna, @RequestParam String localNombre, HttpServletRequest request) throws IOException {
        return pharmacyService.getPharmaciesOnDuty(comuna,localNombre,Calendar.getInstance(request.getLocale()));
    }

}
