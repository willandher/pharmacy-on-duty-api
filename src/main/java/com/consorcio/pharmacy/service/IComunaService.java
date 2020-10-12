package com.consorcio.pharmacy.service;

import com.consorcio.pharmacy.dto.ComunaDto;

import java.io.IOException;
import java.util.List;

public interface IComunaService {
    List<ComunaDto> allComunas() throws IOException;
    ComunaDto findComunaByName(String nameComuna) throws IOException;
}
