package org.kk.tirelist.service;

import java.util.List;

import org.kk.tirelist.dto.tire.CreateTireDto;
import org.kk.tirelist.dto.tire.TireDto;

public interface TireService {
    TireDto createTire(CreateTireDto createTireDto);
    List<TireDto> getAllTires();
    TireDto getTireById(Long tid);
    TireDto addItemToRow(Long rid, Long iid);
    TireDto removeItemFromRow(Long rid, Long iid);
    TireDto addItemToHolder(Long tid, Long iid);
    TireDto removeItemFromHolder(Long tid, Long iid);
}

