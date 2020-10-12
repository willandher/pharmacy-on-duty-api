package com.consorcio.pharmacy.service;

import com.consorcio.pharmacy.config.DateUtils;
import com.consorcio.pharmacy.dto.ComunaDto;
import com.consorcio.pharmacy.dto.PharmacyDto;
import com.consorcio.pharmacy.exception.NotFoundException;
import com.consorcio.pharmacy.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@Service
public class PharmacyServiceImpl implements IPharmacyService {

    @Autowired
    DateUtils dateUtils;

    @Autowired
    PharmacyRepository pharmacyRepository;

    @Override
    public List<PharmacyDto> getPharmacyByIdRegion(String idRegion) {
        return pharmacyRepository.findPharmacyByIdRegion(idRegion);
    }

    @Override
    public List<PharmacyDto> getPharmaciesOnDuty(String comuna, String localNombre, Calendar calendar) throws IOException {
        String horaActual = dateUtils.getCurrentHour(calendar);
        System.out.println("Veamos la hora actual "+horaActual);
        List<PharmacyDto> a = pharmacyRepository.pharmaciesOnDuty(comuna,localNombre,horaActual);
        if(!a.isEmpty()) return a; else throw new NotFoundException("Local [local: " + localNombre + "] no existe existe");
    }

    @Override
    public List<String> getLocalByComuna(String comuna,String idRegion) throws IOException {
        return pharmacyRepository.localByComuna(comuna,idRegion);
    }

    @Override
    public List<String> getLocales() throws IOException {
        return pharmacyRepository.locales();
    }


}
