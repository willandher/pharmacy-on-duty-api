package com.consorcio.pharmacy.service;
import com.consorcio.pharmacy.dto.ComunaDto;
import com.consorcio.pharmacy.exception.NotFoundException;
import com.consorcio.pharmacy.repository.ComunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComunaServiceImpl implements IComunaService {

    @Autowired
    ComunaRepository comunaRepository;

    @Override
    public List<ComunaDto> allComunas() {
        return this.comunaRepository.getAllComunas();
    }

    @Override
    public ComunaDto findComunaByName(String nameComuna) {
        ComunaDto comunaDto = comunaRepository.findComunaByName(nameComuna);
        if (comunaDto != null) return comunaDto;
        else throw new NotFoundException("comuna [comuna: " + nameComuna + "] no existe existe");
    }
}
