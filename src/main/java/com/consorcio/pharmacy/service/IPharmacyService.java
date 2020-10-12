package com.consorcio.pharmacy.service;

import com.consorcio.pharmacy.dto.ComunaDto;
import com.consorcio.pharmacy.dto.PharmacyDto;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public interface IPharmacyService {

    List<PharmacyDto> getPharmacyByIdRegion(String idRegion);

    List<PharmacyDto> getPharmaciesOnDuty(String comuna, String comunaLocal, Calendar calendar) throws IOException;

    List<String> getLocalByComuna(String comuna,String idRegion) throws IOException;

    List<String> getLocales() throws IOException;
}
