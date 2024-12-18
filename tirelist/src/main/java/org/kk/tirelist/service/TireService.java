package org.kk.tirelist.service;

import java.util.List;

import org.kk.tirelist.dto.tire.CreateTireDto;
import org.kk.tirelist.dto.tire.TireDto;

public interface TireService {
    TireDto createTire(CreateTireDto createTireDto);
    List<TireDto> getAllTires();
}
